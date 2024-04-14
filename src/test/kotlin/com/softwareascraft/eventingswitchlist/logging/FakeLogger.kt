package com.softwareascraft.eventingswitchlist.logging

class FakeLogger : SystemLogger {
    private var currentMessage: String = ""

    override fun printLn(message: String) {
        this.currentMessage = message
    }

    fun lastMessage(): String {
        return this.currentMessage
    }

}