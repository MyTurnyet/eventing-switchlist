package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("rolling_stock")
data class RollingStockDto(
    @Id val id: ObjectId = ObjectId(),
    val road: String,
    val number: Int,
    val aar: String,
    val description: String,
    val length: Int,
    val color: String
) : LayoutDto
