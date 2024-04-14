package com.softwareascraft.eventingswitchlist.receivers

class SwitchlistSleepWorker: SleepWorker {
    override fun workOn(message: String) {

    }
}
interface SleepWorker: SwitchListWorker<String>
interface SwitchListWorker<T> {
    fun workOn(message: T)
}
