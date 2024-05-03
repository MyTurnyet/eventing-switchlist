package com.softwareascraft.eventingswitchlist.controllers.layout

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.softwareascraft.eventingswitchlist.data.FakeFreightCarRepository
import com.softwareascraft.eventingswitchlist.models.FreightCar
import com.softwareascraft.eventingswitchlist.models.RollingStockDto
import org.bson.types.ObjectId
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Tag("unit")
class FreightCarInventoryControllerTests {
    @Test
    fun `creates FreightCarInventoryController`() {
        val id = ObjectId()
        val rollingStockDto = RollingStockDto(id, "CPR", 9876, "XM", "CPR 9876", 50, "RED")

        val repository = FakeFreightCarRepository()
        repository.setReturnValue(rollingStockDto)
        val controller = FreightCarInventoryController(repository)

        val responseEntity: ResponseEntity<FreightCar> = controller.getCarById(id.toString())

        val freightCar = responseEntity.body!!
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(freightCar.roadMarkings).isEqualTo(rollingStockDto.description)
        assertThat(freightCar.id().toString()).isEqualTo(id.toString())
    }
}