package com.softwareascraft.eventingswitchlist.models

import org.assertj.core.api.Assertions.assertThat
import org.bson.types.ObjectId
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class StationTests {
    private val id = ObjectId()
    private val boxcarId = ObjectId()
    private val industryId = ObjectId()
    private val stationName = "Echo Lake"
    private lateinit var industry: Industry
    private lateinit var freightCar: FreightCar

    private val industryName = "Malt Bee Brewery"
    private val maximumCars = 1
    private val rollingStockDto = RollingStockDto(boxcarId, "BNSF", 1234, "XM", "BNSF 1234", 0, "")

    @BeforeEach
    fun setup() {
        freightCar = FreightCar.fromDto(rollingStockDto)
        industry = Industry(industryId, industryName, maximumCars)
        industry.place(freightCar)

    }

    @Test
    fun `implements LayoutObject`() {
        val industriesAtStationList: List<Industry> = listOf(industry)
        val station = Station(id, stationName, industriesAtStationList)
        assertThat(station.id()).isEqualTo(id.toString())
        assertThat(station.name()).isEqualTo(stationName)

        val industryDtoList: List<IndustryDto> = listOf(industry.toDto())
        assertThat(station.toDto()).isEqualTo(StationDto(id, stationName, industryDtoList))
    }

    @Test
    fun `station creates nullObject`() {
        val nullObject = Station.nullObject()
        assertThat(nullObject.isNull()).isTrue()
        assertThat(nullObject.name()).isEqualTo("")
    }
}

