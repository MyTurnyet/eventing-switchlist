package com.softwareascraft.eventingswitchlist.controllers.layout

import com.softwareascraft.eventingswitchlist.data.FreightCarRepository
import com.softwareascraft.eventingswitchlist.models.FreightCar
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/freight-cars")
class FreightCarInventoryController(val repository: FreightCarRepository) {
    @GetMapping("/{freightCarId}")
    fun getCarById(@PathVariable freightCarId: String): ResponseEntity<FreightCar> {
        val freightCar = repository.findById(freightCarId)
        return ResponseEntity.ok(freightCar)
    }
    @GetMapping("/")
    fun getAll(): ResponseEntity<List<FreightCar>> {
        val freightCarList = repository.getAll()
        return ResponseEntity.ok(freightCarList)
    }
}