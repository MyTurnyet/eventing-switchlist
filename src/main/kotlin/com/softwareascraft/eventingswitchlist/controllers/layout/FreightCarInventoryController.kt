package com.softwareascraft.eventingswitchlist.controllers.layout

import com.softwareascraft.eventingswitchlist.data.FreightCarMongoRepository
import com.softwareascraft.eventingswitchlist.models.FreightCar
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity

class FreightCarInventoryController(val repository: FreightCarMongoRepository) {
    fun getCarById(freightCarId: String): ResponseEntity<FreightCar> {
//        val freightCarOptional = repository.findById(freightCarId).orElse(FreightCar())
        return ResponseEntity.ok(FreightCar(ObjectId(), "FC", "BNSF", 1234))
    }
}