package com.softwareascraft.eventingswitchlist.controllers.layout

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import com.softwareascraft.eventingswitchlist.controllers.status.CarStatusControllerTestConfiguration
import com.softwareascraft.eventingswitchlist.data.FakeFreightCarRepository
import com.softwareascraft.eventingswitchlist.models.FreightCar
import com.softwareascraft.eventingswitchlist.models.RollingStockDto
import org.assertj.core.api.Assertions
import org.bson.types.ObjectId
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Tag("unit")
class FreightCarInventoryControllerTests {
    @Test
    fun `creates gets car by Id`() {
        val id = ObjectId()
        val rollingStockDto = RollingStockDto(id, "CPR", 9876, "XM", "CPR 9876", 50, "RED")

        val repository = FakeFreightCarRepository()
        repository.setReturnValue(rollingStockDto)
        val controller = FreightCarInventoryController(repository)

        val responseEntity: ResponseEntity<FreightCar> = controller.getCarById(id.toString())

        val freightCar = responseEntity.body!!
        assertThat(responseEntity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(freightCar.roadMarkings).isEqualTo(rollingStockDto.description)
        assertThat(freightCar.id()).isEqualTo(id.toString())
    }

    @Test
    fun `get all freight cars in repository`() {
        val rollingStockDto1 = RollingStockDto(ObjectId(), "CPR", 9876, "XM", "CPR 9876", 50, "RED")
        val rollingStockDto2 = RollingStockDto(ObjectId(), "CPR", 9876, "XM", "CPR 9876", 50, "RED")

        val repository = FakeFreightCarRepository()
        repository.carsToReturn(listOf(rollingStockDto1, rollingStockDto2))
        val controller = FreightCarInventoryController(repository)

        val responseEntity: ResponseEntity<List<FreightCar>> = controller.getAll()
        val freightCars = responseEntity.body!!
        assertThat(freightCars).isNotEmpty()
        assertThat(freightCars.size).isEqualTo(2)

    }
}

@Tag("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(CarStatusControllerTestConfiguration::class)
class FreightCarIntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `calls add pizza order on controller`() {
        val entity = restTemplate.getForEntity<FreightCar>("/api/freight-cars")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)

    }
}