package com.softwareascraft.eventingswitchlist.receivers

import com.softwareascraft.eventingswitchlist.logging.SystemLogger

class MessageReceiver(private val instanceNumber: Int, private val logger: SystemLogger) {
    fun receiveMessage(message: String) {
        logger.printLn("instance $instanceNumber: $message")
    }

}
