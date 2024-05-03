package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.FreightCar
import com.softwareascraft.eventingswitchlist.models.RollingStockDto

class FakeFreightCarRepository : FreightCarRepository {
    private lateinit var dtoToReturn: RollingStockDto

    override fun findById(freightCarId: String): FreightCar {
        return FreightCar.fromDto(dtoToReturn)
    }

    fun setReturnValue(rollingStockDto: RollingStockDto) {
        this.dtoToReturn = rollingStockDto
    }
}