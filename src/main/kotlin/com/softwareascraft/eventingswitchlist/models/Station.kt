package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

class Station(private val id: ObjectId, private val name: String) : LayoutObject<StationDto> {
    override fun id(): String {
        return this.id.toString()
    }

    fun name(): String {
        return this.name
    }

    override fun toDto(): StationDto {
        return StationDto(this.id, this.name)
    }

}
