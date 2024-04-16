package com.softwareascraft.eventingswitchlist.configuration

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softwareascraft.eventingswitchlist.logging.FakeLogger
import com.softwareascraft.eventingswitchlist.receivers.FakeSleepWorker
import com.softwareascraft.eventingswitchlist.wrappers.FakeStopWatch
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.amqp.core.Queue

@Tag("unit")
class RabbitConfigurationTests {
    @Test
    fun `creates RabbitConfiguration`() {
        val logger = FakeLogger()
        val stopWatch = FakeStopWatch(4)
        val sleepWorker = FakeSleepWorker(logger)

        val obj = RabbitConfiguration(logger, stopWatch, sleepWorker)
        val queue: Queue = obj.queue()
        assertThat(queue.name).isEqualTo("eventing-switchlist")
    }
}