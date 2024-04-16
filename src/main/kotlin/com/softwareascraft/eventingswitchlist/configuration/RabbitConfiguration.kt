package com.softwareascraft.eventingswitchlist.configuration

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.receivers.MessageReceiver
import com.softwareascraft.eventingswitchlist.receivers.SleepWorker
import com.softwareascraft.eventingswitchlist.senders.EventingConnection
import com.softwareascraft.eventingswitchlist.wrappers.StopWatchWrapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfiguration(
    val logger: SystemLogger,
    val stopWatch: StopWatchWrapper,
    val sleepWorker: SleepWorker
) {
    @Bean
    fun queue(): Queue {
        return Queue("eventing-switchlist")
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

}
