package com.softwareascraft.eventingswitchlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@Tag("unit")
class PizzaOrderControllerTests {
    @Test
    fun `creates PizzaOrderController`() {
        val controller = PizzaOrderController()
        val orderName = "Small Pepperoni"
        val pizzaOrder = controller.addPizzaOrder(orderName)
        assertThat(pizzaOrder.pizzaName).isEqualTo(orderName)
        assertThat(pizzaOrder.orderId).isEqualTo("12345")
    }
}


@Tag("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaOrderIntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `calls add pizza order on controller`() {
        val entity = restTemplate.getForEntity<PizzaOrderDTO>("/api/pizza/addOrder/pepperoni")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body?.pizzaName ?: "").contains("pepperoni")
    }
}