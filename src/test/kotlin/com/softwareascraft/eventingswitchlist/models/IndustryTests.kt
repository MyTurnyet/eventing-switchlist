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
    private lateinit var industry: Industry
    private val industryName = "Malt Bee Brewery"

    @BeforeEach
    fun setup() {
        industry = Industry(id, industryName, 1)
    }

    @Test
    fun `implements LayoutObject`() {
        assertThat(industry.id()).isEqualTo(id.toString())
        assertThat(industry.toDto()).isEqualTo(IndustryDto(id, industryName))
    }

    @Test
    fun `creates empty industry`() {
        assertThat(industry.name()).isEqualTo(industryName)
        assertThat(industry.isEmpty()).isTrue()
    }

    @Test
    fun `places freight car at industry`() {
        val boxcarId = ObjectId()
        val rollingStockDto = RollingStockDto(boxcarId, "BNSF", 1234, "XM", "BNSF 1234", 0, "")
        val freightCar = FreightCar.fromDto(rollingStockDto)

        industry.place(freightCar)

        assertThat(industry.isEmpty()).isFalse()
    }
}