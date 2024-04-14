package com.softwareascraft.eventingswitchlist.configuration

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.receivers.MessageReceiver
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfiguration {
    @Bean
    fun queue(): Queue {
        return Queue("eventing-switchlist")
    }

    companion object {
        @Bean
        fun receiver1(systemLogger: SystemLogger): MessageReceiver {
            return MessageReceiver(1, systemLogger)
        }

        @Bean
        fun receiver2(systemLogger: SystemLogger): MessageReceiver {
            return MessageReceiver(1, systemLogger)
        }
    }
}
