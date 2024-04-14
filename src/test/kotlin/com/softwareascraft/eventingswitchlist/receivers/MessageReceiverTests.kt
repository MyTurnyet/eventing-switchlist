package com.softwareascraft.eventingswitchlist.receivers

import assertk.assertThat
import assertk.assertions.containsExactlyInAnyOrder
import assertk.assertions.isTrue
import com.softwareascraft.eventingswitchlist.logging.FakeLogger
import com.softwareascraft.eventingswitchlist.wrappers.FakeStopWatch
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class MessageReceiverTests {
    @Test
    fun `creates MessageReceiver`() {
        val fakeLogger = FakeLogger()
        val fakeStopWatch = FakeStopWatch(3)
        val fakeSwitchListWorker = FakeSleepWorker(fakeLogger)
        val messageReceiver = MessageReceiver(1, fakeLogger, fakeStopWatch, fakeSwitchListWorker)
        val testMessage = "test message"
        messageReceiver.receiveMessage(testMessage)
        assertThat(fakeStopWatch.startFunctionCalled).isTrue()
        assertThat(fakeStopWatch.stopFunctionCalled).isTrue()
        val receivedMessage = "instance 1 [x] Received '$testMessage'"
        val finishedMessage = "instance 1 [x] Done in 3.0s"
        val doingWorkMessage = "doing work on '$testMessage'"
        val sleepWorkerMessage = "SleepWorker: Sleeping on '$testMessage'"
        assertThat(fakeLogger.currentMessages).containsExactlyInAnyOrder(
            receivedMessage,
            finishedMessage,
            doingWorkMessage,
            sleepWorkerMessage
        )
    }
}

class FakeSleepWorker(val fakeLogger: FakeLogger) : SleepWorker {
    override fun workOn(message: String) {
        fakeLogger.printLn("SleepWorker: Sleeping on '$message'")
    }

}


