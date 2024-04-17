package com.softwareascraft.eventingswitchlist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class EventingSwitchlistApplication

fun main(args: Array<String>) {
    runApplication<EventingSwitchlistApplication>(*args)
}
