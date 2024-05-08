package com.softwareascraft.eventingswitchlist.models

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isTrue
import org.bson.types.ObjectId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class IndustryTests {
    private val id = ObjectId()
    private val boxcarId = ObjectId()
    private val maximumCars = 1
    private val rollingStockDto = RollingStockDto(boxcarId, "BNSF", 1234, "XM", "BNSF 1234", 0, "")
    private lateinit var industry: Industry
    private lateinit var freightCar: FreightCar
    private val industryName = "Malt Bee Brewery"

    @BeforeEach
    fun setup() {
        freightCar = FreightCar.fromDto(rollingStockDto)
        industry = Industry(id, industryName, maximumCars)
    }

    @Test
    fun `implements LayoutObject`() {
        assertThat(industry.id()).isEqualTo(id.toString())
        val stockDtoList = listOf(freightCar.toDto())
        assertThat(industry.toDto()).isEqualTo(IndustryDto(id, industryName,maximumCars, stockDtoList))
    }

    @Test
    fun `creates empty industry`() {
        assertThat(industry.name()).isEqualTo(industryName)
        assertThat(industry.needsCar(freightCar)).isTrue()
    }

    @Test
    fun `places freight car at industry`() {
        industry.place(freightCar)
        assertThat(industry.needsCar(freightCar)).isFalse()
    }
}