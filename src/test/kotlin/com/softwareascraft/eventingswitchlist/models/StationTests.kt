package com.softwareascraft.eventingswitchlist.models

import org.assertj.core.api.Assertions.assertThat
import org.bson.types.ObjectId
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class StationTests {
    private val id = ObjectId()
    private val stationName = "Echo Lake"

    @Test
    fun `implements LayoutObject`() {
        val industriesAtStationList: List<Industry> = listOf()
        val station = Station(id, stationName, industriesAtStationList)
        assertThat(station.id()).isEqualTo(id.toString())
        assertThat(station.name()).isEqualTo(stationName)

        val industryDtoList: List<IndustryDto> = listOf()
        assertThat(station.toDto()).isEqualTo(StationDto(id, stationName, industryDtoList))
    }

    @Test
    fun `station creates nullObject`() {
        val nullObject = Station.nullObject()
        assertThat(nullObject.isNull()).isTrue()
        assertThat(nullObject.name()).isEqualTo("")
    }
}

