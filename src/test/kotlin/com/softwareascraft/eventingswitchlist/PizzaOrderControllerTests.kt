package com.softwareascraft.eventingswitchlist

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

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