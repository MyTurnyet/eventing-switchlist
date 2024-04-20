package com.softwareascraft.eventingswitchlist.models

interface FreightCar {
    val roadMarkings: String
    fun isAarType(expectedType: CarType): Boolean
}


abstract class RollingStock(private val roadName: String, private val roadNumber: Int, private val carType: CarType) :
    FreightCar {

    fun isEmpty(): Boolean {
        return true
    }

    override val roadMarkings: String
        get() = "$roadName $roadNumber"

    override fun isAarType(expectedType: CarType): Boolean {
        return this.carType == expectedType
    }

}

class Boxcar(roadName: String, roadNumber: Int) :
    RollingStock(roadName, roadNumber, CarType.Boxcar) {

}