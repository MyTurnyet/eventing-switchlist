package com.softwareascraft.eventingswitchlist.senders

import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.TopicExchange

interface EventingConnection {
    fun convertAndSend(exchange: FanoutExchange, message: String)
    fun convertAndSend(exchange: TopicExchange,key:String, message: String)
    fun convertAndSend(queueName: String, message: String)
}