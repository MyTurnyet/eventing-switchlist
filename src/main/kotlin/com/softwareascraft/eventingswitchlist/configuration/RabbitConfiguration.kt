package com.softwareascraft.eventingswitchlist.configuration

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.receivers.MessageReceiver
import com.softwareascraft.eventingswitchlist.receivers.SleepWorker
import com.softwareascraft.eventingswitchlist.senders.EventingConnection
import com.softwareascraft.eventingswitchlist.wrappers.StopWatchWrapper
import org.springframework.amqp.core.FanoutExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfiguration(
    val logger: SystemLogger,
    val stopWatch: StopWatchWrapper,
    val sleepWorker: SleepWorker
) {

    @Bean
    fun queue(@Value("\${softwareAsCraft.eventing.queue.name}") queueName: String): Queue {
        logger.printLn("connecting to $queueName")
        return Queue(queueName)
    }

    @Bean
    fun receiver1(
    ): MessageReceiver {
        return MessageReceiver(1, logger, stopWatch, sleepWorker)
    }

    @Bean
    fun receiver2(
    ): MessageReceiver {
        return MessageReceiver(1, logger, stopWatch, sleepWorker)
    }

    @Bean
    fun eventingConnection(rabbitTemplate: RabbitTemplate): EventingConnection {
        return RabbitEventingConnection(rabbitTemplate)
    }

    @Bean
    fun fanOut(@Value("\${softwareAsCraft.eventing.exchange.name}") exchangeName: String): FanoutExchange {
        logger.printLn("connecting to exchange: $exchangeName")
        return FanoutExchange(exchangeName)
    }

}
