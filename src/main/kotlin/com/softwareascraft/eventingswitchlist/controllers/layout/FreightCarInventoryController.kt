package com.softwareascraft.eventingswitchlist.controllers.layout

import com.softwareascraft.eventingswitchlist.models.FreightCar
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity

class FreightCarInventoryController {
    fun getCarById(freightCarId: String): ResponseEntity<FreightCar> {
        return ResponseEntity.ok(FreightCar(ObjectId(), "FC", "BNSF", 1234))
    }
}