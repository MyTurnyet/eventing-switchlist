package com.softwareascraft.eventingswitchlist.models

import org.bson.types.ObjectId

class Industry(private val id: ObjectId, private val industryName: String, private val maximumCars: Int) :
    LayoutObject<IndustryDto> {
    private val freightCarsAtIndustry: MutableList<FreightCar> = mutableListOf()

    override fun id(): String {
        return this.id.toString()
    }

    override fun toDto(): IndustryDto {
        val stockDtoList = this.freightCarsAtIndustry.map { it.toDto() }
        return IndustryDto(id, industryName, maximumCars, stockDtoList)
    }

    fun name(): String {
        return this.industryName
    }

    fun place(freightCar: FreightCar) {
        this.freightCarsAtIndustry.add(freightCar)
    }

    fun needsCar(freightCar: FreightCar): Boolean {
        return isEmpty() || !isFull()
    }

    private fun isEmpty(): Boolean {
        return this.freightCarsAtIndustry.isEmpty()
    }

    private fun isFull() = this.maximumCars <= this.freightCarsAtIndustry.size

    companion object {
        fun nullObject(): Industry {
            return Industry(ObjectId(), "", 0)
        }

        fun fromDto(industryDto: IndustryDto): Industry {
            val industry = Industry(industryDto.id, industryDto.industryName, industryDto.maximumCars)
            industryDto.stockDtoList.forEach { rollingStockDto -> industry.place(FreightCar.fromDto(rollingStockDto)) }
            return industry
        }
    }

}

fun Industry.isNull(): Boolean {
    return this.name() == ""
}


