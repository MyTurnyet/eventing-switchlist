package com.softwareascraft.eventingswitchlist.wrappers

class FakeStopWatch(private val timeToReturnInSeconds: Int) : StopWatchWrapper {
    var startFunctionCalled: Boolean = false
    var stopFunctionCalled: Boolean = false
    override val totalTimeInSeconds: Double
        get() = this.timeToReturnInSeconds.toDouble()

    override fun start() {
        this.startFunctionCalled = true
    }

    override fun stop() {
        this.stopFunctionCalled = true
    }

}