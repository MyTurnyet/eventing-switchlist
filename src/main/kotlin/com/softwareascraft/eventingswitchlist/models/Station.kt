package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

class Station(
    private val id: ObjectId,
    private val stationName: String,
    private val industriesAtStationList: List<Industry>
) : LayoutObject<StationDto> {
    override fun id(): String {
        return this.id.toString()
    }

    fun name(): String {
        return this.stationName
    }

    override fun toDto(): StationDto {
        val industryDtoList = this.industriesAtStationList.map { industry -> industry.toDto() }
        return StationDto(this.id, this.stationName, industryDtoList)
    }

    companion object {
        fun nullObject(): Station {
            return Station(ObjectId(), "", listOf())
        }
    }

}

fun Station.isNull(): Boolean {
    return this.name() == ""
}
