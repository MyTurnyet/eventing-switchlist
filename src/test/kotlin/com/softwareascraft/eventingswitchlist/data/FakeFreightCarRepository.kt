package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.FreightCar
import com.softwareascraft.eventingswitchlist.models.RollingStockDto

class FakeFreightCarRepository : FreightCarRepository {
    private var rollingStockDtoList: MutableList<RollingStockDto> = mutableListOf()
    private lateinit var dtoToReturn: RollingStockDto

    override fun findById(freightCarId: String): FreightCar {
        return FreightCar.fromDto(dtoToReturn)
    }

    override fun getAll(): List<FreightCar> {
        return rollingStockDtoList.map { FreightCar.fromDto(it) }
    }

    fun setReturnValue(rollingStockDto: RollingStockDto) {
        this.dtoToReturn = rollingStockDto
    }

    fun carsToReturn(rollingStockDtoList: List<RollingStockDto>) {
        this.rollingStockDtoList.addAll(rollingStockDtoList)
    }
}