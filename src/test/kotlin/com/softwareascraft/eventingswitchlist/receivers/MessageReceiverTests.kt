package com.softwareascraft.eventingswitchlist.receivers

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import com.softwareascraft.eventingswitchlist.logging.FakeLogger
import com.softwareascraft.eventingswitchlist.wrappers.FakeStopWatch
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class MessageReceiverTests {
    @Test
    fun `creates MessageReceiver`() {
        val fakeStopWatch = FakeStopWatch(3)
        val fakeLogger = FakeLogger()
        val messageReceiver = MessageReceiver(1, fakeLogger, fakeStopWatch)
        val testMessage = "test message"
        messageReceiver.receiveMessage(testMessage)
        assertThat(fakeStopWatch.startFunctionCalled).isTrue()
        assertThat(fakeLogger.lastMessage()).isEqualTo("instance 1 [x] Received '$testMessage'")
    }
}

