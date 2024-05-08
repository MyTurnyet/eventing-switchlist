package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

class Station(private val id: ObjectId, private val stationName: String) : LayoutObject<StationDto> {
    override fun id(): String {
        return this.id.toString()
    }

    fun name(): String {
        return this.stationName
    }

    override fun toDto(): StationDto {
        return StationDto(this.id, this.stationName)
    }

    companion object {
        fun nullObject(): Station {
            return Station(ObjectId(), "")
        }
    }

}
fun Station.isNull(): Boolean {
    return this.name() ==""
}
