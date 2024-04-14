package com.softwareascraft.eventingswitchlist

import com.softwareascraft.eventingswitchlist.logging.ConsoleLogger
import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.wrappers.StopWatchWrapper
import com.softwareascraft.eventingswitchlist.wrappers.SystemStopWatch
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class EventingSwitchlistApplication

@Bean
fun systemLogger(): SystemLogger {
    return ConsoleLogger()
}

@Bean
fun stopWatchWrapper():StopWatchWrapper{
    return SystemStopWatch()
}

fun main(args: Array<String>) {
    runApplication<EventingSwitchlistApplication>(*args)
}
