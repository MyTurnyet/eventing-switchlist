package com.softwareascraft.eventingswitchlist.models

import assertk.assertThat
import assertk.assertions.isEqualTo
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
        industry = Industry(id, industryName)
    }

    @Test
    fun `implements LayoutObject`() {
        assertThat(industry.id()).isEqualTo(id.toString())
        assertThat(industry.toDto()).isEqualTo(IndustryDto(id, industryName))
    }

    @Test
    fun `creates industry`() {
        assertThat(industry.name()).isEqualTo(industryName)
    }
}