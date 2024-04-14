package com.softwareascraft.eventingswitchlist.logging

class FakeLogger : SystemLogger {
    var currentMessages: MutableList<String> = ArrayList()

    override fun printLn(message: String) {
        currentMessages.add(message)
    }
}