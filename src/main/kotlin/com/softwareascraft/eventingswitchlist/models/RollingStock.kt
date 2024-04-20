package com.softwareascraft.eventingswitchlist.models

interface FreightCar {
    val roadMarkings: String
    fun isAarType(expectedType: CarType): Boolean
}

interface CarriesLoad {
    fun load()
    fun isLoaded(): Boolean
}

abstract class RollingStock(private val roadName: String, private val roadNumber: Int, private val carType: CarType) :
    FreightCar {

    override val roadMarkings: String
        get() = "$roadName $roadNumber"

    override fun isAarType(expectedType: CarType): Boolean {
        return this.carType == expectedType
    }

}

class Boxcar(roadName: String, roadNumber: Int) : CarriesLoad,
    RollingStock(roadName, roadNumber, CarType.Boxcar) {
    private var loaded: Boolean = false

    override fun load() {
        this.loaded = true
    }

    override fun isLoaded(): Boolean {
        return this.loaded
    }

}