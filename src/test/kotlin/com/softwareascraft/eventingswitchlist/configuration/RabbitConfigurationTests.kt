package com.softwareascraft.eventingswitchlist.configuration

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
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
        val queueName = "some.queue.name"
        val queue: Queue = obj.queue(queueName)
        val exchangeName = "some.exchange.name"
        val fanoutExchange = obj.fanOut(exchangeName)
        assertThat(obj.receiver1()).isNotNull()
        assertThat(obj.receiver2()).isNotNull()
        assertThat(fanoutExchange.name).isEqualTo(exchangeName)
        assertThat(queue.name).isEqualTo(queueName)
    }
}