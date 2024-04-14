package com.softwareascraft.eventingswitchlist.configuration

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softwareascraft.eventingswitchlist.receivers.FakeLogger
import com.softwareascraft.eventingswitchlist.receivers.MessageReceiver
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.amqp.core.Queue

@Tag("unit")
class RabbitConfigurationTests {
    @Test
    fun `creates RabbitConfiguration`() {
        val obj = RabbitConfiguration()
        val queue: Queue = obj.queue()
        val logger = FakeLogger()
        assertThat(queue.name).isEqualTo("eventing-switchlist")

        var messageReceiver1: MessageReceiver = RabbitConfiguration.receiver1(logger)
        var messageReceiver2: MessageReceiver = RabbitConfiguration.receiver2(logger)


    }
}