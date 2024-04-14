package com.softwareascraft.eventingswitchlist.configuration

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.receivers.MessageReceiver
import com.softwareascraft.eventingswitchlist.wrappers.StopWatchWrapper
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
        fun receiver1(systemLogger: SystemLogger, stopWatch: StopWatchWrapper): MessageReceiver {
            return MessageReceiver(1, systemLogger, stopWatch)
        }

        @Bean
        fun receiver2(systemLogger: SystemLogger, stopWatch: StopWatchWrapper): MessageReceiver {
            return MessageReceiver(1, systemLogger, stopWatch)
        }
    }
}
