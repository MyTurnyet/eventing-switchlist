package com.softwareascraft.eventingswitchlist.receivers

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class MessageReceiverTests {
    @Test
    fun `creates MessageReceiver`() {
        val fakeLogger = FakeLogger()
        val messageReceiver = MessageReceiver(1, fakeLogger)
        messageReceiver.receiveMessage("test message")
        assertThat(fakeLogger.lastMessage()).isEqualTo("instance 1: test message")
    }
}

class FakeLogger : SystemLogger {
    private var currentMessage: String = ""

    override fun printLn(message: String) {
        this.currentMessage = message
    }

    fun lastMessage(): String {
        return this.currentMessage
    }

}
