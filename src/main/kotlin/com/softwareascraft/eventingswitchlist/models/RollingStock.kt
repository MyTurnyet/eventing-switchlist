package com.softwareascraft.eventingswitchlist.models

interface FreightCar {
    val roadMarkings: String
    fun isAarType(expectedType: String): Boolean
}

interface CarriesLoad {
    fun load()
    fun isLoaded(): Boolean
}

abstract class RollingStock(
    private val roadName: String,
    private val roadNumber: Int,
    private val carType2: String = ""
) :
    FreightCar {

    override val roadMarkings: String
        get() = "$roadName $roadNumber"

    override fun isAarType(expectedType: String): Boolean {
        return this.carType2 == expectedType
    }

}

class Boxcar(roadName: String, roadNumber: Int) : CarriesLoad,
    RollingStock(roadName, roadNumber, "XM") {
    private var loaded: Boolean = false

    override fun load() {
        this.loaded = true
    }

    override fun isLoaded(): Boolean {
        return this.loaded
    }

}