package com.softwareascraft.eventingswitchlist.models

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class RollingStockTests {
    @Test
    fun `creates RollingStock`() {
        val rollingStock = RollingStock("BNSF", 1234)
        assertThat(rollingStock.roadMarkings()).isEqualTo("BNSF 1234")
        assertThat(rollingStock.isEmpty()).isTrue()

    }
}