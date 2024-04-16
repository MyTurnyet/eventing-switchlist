package com.softwareascraft.eventingswitchlist.configuration

import com.softwareascraft.eventingswitchlist.logging.ConsoleLogger
import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.receivers.SleepWorker
import com.softwareascraft.eventingswitchlist.receivers.SwitchlistSleepWorker
import com.softwareascraft.eventingswitchlist.wrappers.StopWatchWrapper
import com.softwareascraft.eventingswitchlist.wrappers.SystemStopWatch
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SystemConfiguration {
    @Bean
    fun systemLogger(): SystemLogger {
        return ConsoleLogger()
    }

    @Bean
    fun stopWatchWrapper(): StopWatchWrapper {
        return SystemStopWatch()
    }

    @Bean
    fun sleepWorker(): SleepWorker {
        return SwitchlistSleepWorker()
    }

}