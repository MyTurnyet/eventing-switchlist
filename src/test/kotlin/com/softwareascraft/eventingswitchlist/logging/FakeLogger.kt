package com.softwareascraft.eventingswitchlist.logging

class FakeLogger : SystemLogger {
    private var currentMessages: MutableList<String> = ArrayList()

    override fun printLn(message: String) {
        currentMessages.add(message)
    }

    fun lastMessage(): String {
        return this.currentMessages.last()
    }

}