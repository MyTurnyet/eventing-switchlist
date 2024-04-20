package com.softwareascraft.eventingswitchlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@Tag("unit")
class CarStatusControllerTests {
    @Test
    fun `creates PizzaOrderController`() {
        val controller = CarStatusController()
        val expectedStatus = CarStatus.EMPTY
        val carId = "12345"
        val rollingStockStatus = controller.getRollingStockStatus(carId)
        assertThat(rollingStockStatus.status).isEqualTo(expectedStatus)
        assertThat(rollingStockStatus.rollingStockId).isEqualTo(carId)
    }
}


@Tag("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaOrderIntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `calls add pizza order on controller`() {
        val entity = restTemplate.getForEntity<RollingStockStatus>("/api/status/rollingStock/24332")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body?.rollingStockId).isEqualTo("24332")
        assertThat(entity.body?.status).isEqualTo(CarStatus.EMPTY)
    }
}