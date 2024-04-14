package com.softwareascraft.eventingswitchlist.logging

class ConsoleLogger:SystemLogger {
    override fun printLn(message:String) {
        System.out.println(message)
    }
}