package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

data class IndustryDto(
    val id: ObjectId,
    val industryName: String,
    val maximumCars: Int,
    val stockDtoList: List<RollingStockDto>
) : LayoutDto