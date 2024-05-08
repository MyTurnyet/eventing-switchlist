package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

class Industry(private val id: ObjectId, private val industryName: String): LayoutObject<IndustryDto> {
    override fun id(): String {
        return this.id.toString()
    }

    override fun toDto(): IndustryDto {
        return IndustryDto(id,industryName)
    }

    fun name(): String {
        return this.industryName
    }

}

data class IndustryDto(val id: ObjectId, val industryName: String) : LayoutDto {

}
