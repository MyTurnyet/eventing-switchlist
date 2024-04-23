package com.softwareascraft.eventingswitchlist.configuration

import com.softwareascraft.eventingswitchlist.senders.EventingConnection
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate

class RabbitEventingConnection(private val template: RabbitTemplate) : EventingConnection {
    override fun convertAndSend(queueName: String, message: String) {
        template.convertAndSend(queueName, message)
    }

    override fun convertAndSend(exchange: FanoutExchange, message: String) {
        sendToExchange(exchange.name, "", message)
    }


    override fun convertAndSend(exchange: TopicExchange, key: String, message: String) {
        sendToExchange(exchange.name, key, message)
    }

    private fun sendToExchange(
        exchangeName: String,
        key: String,
        message: String
    ) {
        template.convertAndSend(exchangeName, key, message)
    }

}