package com.softwareascraft.eventingswitchlist.wrappers

interface StopWatchWrapper {
    val totalTimeInSeconds: Double
    fun start()
    fun stop()
}