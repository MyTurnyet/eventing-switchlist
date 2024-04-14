package com.softwareascraft.eventingswitchlist.configuration

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softwareascraft.eventingswitchlist.logging.FakeLogger
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.amqp.core.Queue

@Tag("unit")
class RabbitConfigurationTests {
    @Test
    fun `creates RabbitConfiguration`() {
        val obj = RabbitConfiguration()
        val queue: Queue = obj.queue()
        assertThat(queue.name).isEqualTo("eventing-switchlist")
    }
}