package com.softwareascraft.eventingswitchlist.senders

import org.springframework.amqp.core.FanoutExchange

interface EventingConnection {
    fun convertAndSend(exchange: FanoutExchange, message: String)
    fun convertAndSend(queueName: String, message: String)
}