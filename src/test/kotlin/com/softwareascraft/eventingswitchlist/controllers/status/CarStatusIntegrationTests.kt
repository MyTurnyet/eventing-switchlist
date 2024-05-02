package com.softwareascraft.eventingswitchlist.controllers.status

import com.softwareascraft.eventingswitchlist.controllers.status.CarStatus
import com.softwareascraft.eventingswitchlist.controllers.status.RollingStockStatus
import com.softwareascraft.eventingswitchlist.senders.MessageSender
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus

@TestConfiguration
class CarStatusControllerTestConfiguration {
    @Bean
    fun messageSender(): MessageSender {
        return FakeMessageSender()
    }
}

@Tag("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(CarStatusControllerTestConfiguration::class)
class CarStatusIntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `calls add pizza order on controller`() {
        val entity = restTemplate.getForEntity<RollingStockStatus>("/api/status/rollingStock/24332")
        Assertions.assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        val rollingStockStatus: RollingStockStatus = entity.body!!
        Assertions.assertThat(rollingStockStatus.rollingStockId).isEqualTo("24332")
        Assertions.assertThat(rollingStockStatus.status).isEqualTo(CarStatus.EMPTY)
    }
}
