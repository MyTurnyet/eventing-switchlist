package com.softwareascraft.eventingswitchlist.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class CarTypeTests {
    @Test
    fun `creates CarType`() {
        val item = CarType.Boxcar
        assertThat(item.abbreviation).isEqualTo("XM")
    }
    @Test
    fun `return correct type from description`() {
        val carType = CarType.getFromAAR("HTC")
        assertThat(carType).isEqualTo(CarType.GrainHopper)
    }
}