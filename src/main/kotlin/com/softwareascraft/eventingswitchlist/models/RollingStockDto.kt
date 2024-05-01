package com.softwareascraft.eventingswitchlist.models

import org.springframework.data.mongodb.core.mapping.Document

@Document("rolling_stock")
data class RollingStockDto(
    val road: String,
    val number: Int,
    val aar: String,
    val description: String,
    val length: Int,
    val color: String
) : LayoutDto()
