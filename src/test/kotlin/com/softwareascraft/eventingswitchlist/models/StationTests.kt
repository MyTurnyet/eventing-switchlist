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
        val station = Station(id, stationName)
        assertThat(station.id()).isEqualTo(id.toString())
        assertThat(station.name()).isEqualTo(stationName)
        assertThat(station.toDto()).isEqualTo(StationDto(id, stationName))
    }

    @Test
    fun `station creates nullObject`() {
        val nullObject = Station.nullObject()
        assertThat(nullObject.isNull()).isTrue()
        assertThat(nullObject.name()).isEqualTo("")
    }
}

