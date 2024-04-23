package com.softwareascraft.eventingswitchlist.senders

import com.softwareascraft.eventingswitchlist.logging.FakeLogger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.TopicExchange

@Tag("unit")
class BoringMessageSenderTests {
    @Test
    fun `creates MessageSender`() {
        val eventingConnection = FakeEventingConnection()
        val logger = FakeLogger()
        val fanoutExchange = TopicExchange("foo.name")

        val sender = BoringMessageSender(logger, eventingConnection, fanoutExchange)

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

    override fun convertAndSend(exchange: TopicExchange, key: String, message: String) {
        this.convertAndSendCalled = true
    }

    override fun convertAndSend(queueName: String, message: String) {
        this.convertAndSendCalled = true
    }

}
