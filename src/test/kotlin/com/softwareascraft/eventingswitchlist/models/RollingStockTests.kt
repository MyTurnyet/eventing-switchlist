package com.softwareascraft.eventingswitchlist.models

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class RollingStockTests {
    @Test
    fun `creates boxcar`() {
        val rollingStock = Boxcar("BNSF", 1234)
        assertThat(rollingStock.roadMarkings).isEqualTo("BNSF 1234")
        assertThat(rollingStock.isAarType(CarType.Boxcar)).isTrue()
    }

    @Test
    fun `implements CarriesLoad`() {
        val rollingStock: CarriesLoad = Boxcar("BNSF", 1234)
        assertThat(rollingStock.isLoaded()).isFalse()
        rollingStock.load()
        assertThat(rollingStock.isLoaded()).isTrue()
    }

}

