package com.softwareascraft.eventingswitchlist.senders

import com.softwareascraft.eventingswitchlist.logging.SystemLogger


class MessageSender(private val logger: SystemLogger, private val eventingConnection: EventingConnection, private val queueName: String) {
    fun send() {
        val builder = StringBuilder("Hello...")

        val message = builder.toString()
        eventingConnection.convertAndSend(queueName, message)
        logger.printLn(" [x] Sent '$message'")
    }
}
