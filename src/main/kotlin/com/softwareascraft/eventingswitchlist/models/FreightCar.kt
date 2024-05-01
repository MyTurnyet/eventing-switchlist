package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

class FreightCar(id: ObjectId, carType: String, roadName: String, roadNumber: Int) : CarriesLoad,
    RollingStock(id, roadName, roadNumber, carType) {
    constructor(roadName: String, roadNumber: Int) : this(ObjectId(), "XM", roadName, roadNumber)

    private var loaded: Boolean = false

    override fun load() {
        this.loaded = true
    }

    override fun isLoaded(): Boolean {
        return this.loaded
    }

    companion object {
        fun fromDto(rollingStockDto: RollingStockDto): FreightCar {
            return FreightCar(rollingStockDto.id, rollingStockDto.aar, rollingStockDto.road, rollingStockDto.number)
        }
    }


}