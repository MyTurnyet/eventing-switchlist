package com.softwareascraft.eventingswitchlist.models

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.bson.types.ObjectId
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class RollingStockTests {
    private val boxcarId = ObjectId()
    private val rollingStockDto = RollingStockDto(boxcarId, "BNSF", 1234, "XM", "BNSF 1234", 0, "")

    @Test
    fun `creates boxcar`() {
        val rollingStock: RailCar = FreightCar("BNSF", 1234)
        assertThat(rollingStock.roadMarkings).isEqualTo("BNSF 1234")
        assertThat(rollingStock.isAarType("XM")).isTrue()
    }

    @Test
    fun `implements CarriesLoad`() {
        val rollingStock: CarriesLoad = FreightCar("BNSF", 1234)
        assertThat(rollingStock.isLoaded()).isFalse()
        rollingStock.load()
        assertThat(rollingStock.isLoaded()).isTrue()
    }

    @Test
    fun `implements LayoutObject`() {
        val rollingStock: LayoutObject<RollingStockDto> = FreightCar(boxcarId, "XM", "BNSF", 1234)
        assertThat(rollingStock.id()).isEqualTo(boxcarId.toString())
        assertThat(rollingStock.toDto()).isEqualTo(rollingStockDto)
    }

    @Test
    fun `RollingStock class creates from DTO`() {
        val freightCar = FreightCar.fromDto(rollingStockDto)
        assertThat(freightCar.id()).isEqualTo(boxcarId.toString())
        assertThat(freightCar.roadMarkings).isEqualTo("${rollingStockDto.road} ${rollingStockDto.number}")
        assertThat(freightCar.isAarType("XM")).isTrue()
    }

}

