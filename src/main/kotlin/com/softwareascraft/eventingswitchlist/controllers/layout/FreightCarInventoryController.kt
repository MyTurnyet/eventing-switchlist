package com.softwareascraft.eventingswitchlist.controllers.layout

import com.softwareascraft.eventingswitchlist.data.FreightCarRepository
import com.softwareascraft.eventingswitchlist.models.FreightCar
import org.springframework.http.ResponseEntity

class FreightCarInventoryController(val repository: FreightCarRepository) {
    fun getCarById(freightCarId: String): ResponseEntity<FreightCar> {
        val freightCar = repository.findById(freightCarId)
        return ResponseEntity.ok(freightCar)
    }
}