package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.RollingStockDto
import org.springframework.data.mongodb.repository.MongoRepository

interface RollingStockRepository:MongoRepository<RollingStockDto, String> {
}