package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

class Industry(private val id: ObjectId, private val industryName: String, private val maximumCars: Int) :
    LayoutObject<IndustryDto> {
    private val freightCarsAtIndustry: MutableList<FreightCar> = mutableListOf()

    override fun id(): String {
        return this.id.toString()
    }

    override fun toDto(): IndustryDto {
        return IndustryDto(id, industryName)
    }

    fun name(): String {
        return this.industryName
    }

    fun isEmpty(): Boolean {
        return this.freightCarsAtIndustry.isEmpty()
    }

    fun place(freightCar: FreightCar) {
        this.freightCarsAtIndustry.add(freightCar)
    }

    fun needsCar(freightCar: FreightCar): Boolean {
        return this.freightCarsAtIndustry.isEmpty() && this.maximumCars > this.freightCarsAtIndustry.size
    }

}

data class IndustryDto(val id: ObjectId, val industryName: String) : LayoutDto {

}
