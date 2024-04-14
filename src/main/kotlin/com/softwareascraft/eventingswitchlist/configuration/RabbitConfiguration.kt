package com.softwareascraft.eventingswitchlist.configuration

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfiguration {
   @Bean
    fun queue():Queue {
        return Queue("eventing-switchlist")
    }

}
