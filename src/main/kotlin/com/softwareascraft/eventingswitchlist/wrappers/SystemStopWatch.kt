package com.softwareascraft.eventingswitchlist.wrappers

import org.springframework.util.StopWatch

class SystemStopWatch:StopWatchWrapper {
    private val stopWatch:StopWatch = StopWatch()
    override val totalTimeInSeconds: Double
        get() = stopWatch.totalTimeSeconds

    override fun start() {
        this.stopWatch.start()
    }

    override fun stop() {
        this.stopWatch.stop()
    }
}