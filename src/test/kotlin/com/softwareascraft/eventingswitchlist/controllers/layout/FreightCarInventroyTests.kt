package com.softwareascraft.eventingswitchlist.controllers.layout

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softwareascraft.eventingswitchlist.models.FreightCar
import org.bson.types.ObjectId
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Tag("unit")
class FreightCarInventoryControllerTests {
    @Test
    fun `creates FreightCarInventoryController`() {
        val controller = FreightCarInventoryController()
        val id = ObjectId()
        val freightCar: ResponseEntity<FreightCar> = controller.getCarById(id.toString())
        assertThat(freightCar.statusCode).isEqualTo(HttpStatus.OK)    }
}