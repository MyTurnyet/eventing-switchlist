package com.softwareascraft.eventingswitchlist.senders

import com.softwareascraft.eventingswitchlist.logging.FakeLogger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.amqp.core.FanoutExchange

@Tag("unit")
class MessageSenderTests {
    @Test
    fun `creates MessageSender`() {
        val eventingConnection = FakeEventingConnection()
        val logger = FakeLogger()
        val fanoutExchange = FanoutExchange("foo.name")

        val sender = MessageSender(logger, eventingConnection, fanoutExchange)

        sender.send()

        assertThat(eventingConnection.convertAndSendCalled).isTrue()
        assertThat(logger.currentMessages).containsExactly(" [x] Sent 'Hello.1'")
    }
}

class FakeEventingConnection : EventingConnection {
    var convertAndSendCalled: Boolean = false
    override fun convertAndSend(exchange: FanoutExchange, message: String) {
        this.convertAndSendCalled = true
    }

    override fun convertAndSend(queueName: String, message: String) {
        this.convertAndSendCalled = true
    }

}