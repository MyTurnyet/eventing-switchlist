package com.softwareascraft.eventingswitchlist.senders

interface EventingConnection {
    fun convertAndSend(queueName:String, message: String, )
}