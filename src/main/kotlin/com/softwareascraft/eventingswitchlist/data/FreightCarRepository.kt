package com.softwareascraft.eventingswitchlist.data

import com.softwareascraft.eventingswitchlist.models.FreightCar

interface FreightCarRepository {
    fun findById(freightCarId: String): FreightCar
    fun getAll(): List<FreightCar>

}
