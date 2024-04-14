package com.softwareascraft.eventingswitchlist.configuration

import assertk.assertThat
import assertk.assertions.isInstanceOf
import assertk.assertions.isNotNull
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class RabbitConfigurationTests {
    @Test
    fun `creates RabbitConfiguration`() {
        val obj = RabbitConfiguration()
    }
}