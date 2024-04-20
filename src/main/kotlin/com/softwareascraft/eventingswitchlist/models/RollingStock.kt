package com.softwareascraft.eventingswitchlist.models

class RollingStock(private val roadName: String, private val roadNumber: Int) {
    fun roadMarkings(): String {
        return "$roadName $roadNumber"
    }

}
