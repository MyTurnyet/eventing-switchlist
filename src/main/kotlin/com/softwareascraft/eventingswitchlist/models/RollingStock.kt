package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

interface FreightCar {
    val roadMarkings: String
    fun isAarType(expectedType: String): Boolean
}

interface CarriesLoad {
    fun load()
    fun isLoaded(): Boolean
}

abstract class RollingStock(
    private val id: ObjectId,
    private val roadName: String,
    private val roadNumber: Int,
    private val carType: String = ""
) : FreightCar, LayoutObject<RollingStockDto> {


    override val roadMarkings: String
        get() = "$roadName $roadNumber"

    override fun isAarType(expectedType: String): Boolean {
        return this.carType == expectedType
    }

    override fun id(): String {
        return this.id.toString()
    }

    override fun toDto(): RollingStockDto {
        return RollingStockDto(this.id, this.roadName, this.roadNumber, this.carType, "$roadName $roadNumber", 0, "")
    }
}

class Boxcar(id: ObjectId, roadName: String, roadNumber: Int) : CarriesLoad,
    RollingStock(id, roadName, roadNumber, "XM") {
    constructor(roadName: String, roadNumber: Int) : this(ObjectId(), roadName, roadNumber)

    private var loaded: Boolean = false

    override fun load() {
        this.loaded = true
    }

    override fun isLoaded(): Boolean {
        return this.loaded
    }


}