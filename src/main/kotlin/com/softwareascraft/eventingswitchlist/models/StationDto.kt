package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

data class StationDto(val id: ObjectId, val stationName: String, val industryDtoList: List<IndustryDto>) : LayoutDto
