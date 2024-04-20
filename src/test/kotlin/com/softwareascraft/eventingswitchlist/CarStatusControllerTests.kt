package com.softwareascraft.eventingswitchlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class CarStatusControllerTests {
    @Test
    fun `creates CarStatusController`() {
        val controller = CarStatusController()
        val expectedStatus = CarStatus.EMPTY
        val carId = "12345"
        val rollingStockStatus = controller.getRollingStockStatus(carId)
        assertThat(rollingStockStatus.status).isEqualTo(expectedStatus)
        assertThat(rollingStockStatus.rollingStockId).isEqualTo(carId)
    }
}


