package com.softwareascraft.eventingswitchlist.senders

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import org.springframework.beans.factory.annotation.Autowired


class MessageSender(
    @Autowired private val logger: SystemLogger,
    @Autowired private val eventingConnection: EventingConnection,
    @Autowired private val queueName: String
) {
    fun send() {
        val builder = StringBuilder("Hello...")

        val message = builder.toString()
        eventingConnection.convertAndSend(queueName, message)
        logger.printLn(" [x] Sent '$message'")
    }
}
