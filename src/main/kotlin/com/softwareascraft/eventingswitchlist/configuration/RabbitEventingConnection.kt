package com.softwareascraft.eventingswitchlist.configuration

import com.softwareascraft.eventingswitchlist.senders.EventingConnection
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate

class RabbitEventingConnection(private val template: RabbitTemplate) : EventingConnection {
    override fun convertAndSend(queueName: String, message: String) {
        template.convertAndSend(queueName, message)
    }

    override fun convertAndSend(exchange: FanoutExchange, message: String) {
        template.convertAndSend(exchange.name,"", message)
    }

}