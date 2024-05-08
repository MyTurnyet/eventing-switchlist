package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.FreightCar
import com.softwareascraft.eventingswitchlist.models.RollingStockDto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

interface FreightCarMongoInterface : MongoRepository<RollingStockDto, String>

@Repository
class FreightCarMongoRepository(val repository: FreightCarMongoInterface) : FreightCarRepository {
    override fun findById(freightCarId: String): FreightCar {
        val rollingStockDto: RollingStockDto = repository.findById(freightCarId).orElse(FreightCar.nullObject().toDto())
        return FreightCar.fromDto(rollingStockDto)
    }

    override fun getAll(): List<FreightCar> {
        TODO("Not yet implemented")
    }
}