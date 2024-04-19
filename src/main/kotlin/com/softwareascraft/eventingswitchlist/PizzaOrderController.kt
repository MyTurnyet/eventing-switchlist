package com.softwareascraft.eventingswitchlist

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/pizza")
class PizzaOrderController {
    @GetMapping("/addOrder/{pizzaOrder}")
    fun addPizzaOrder(@PathVariable pizzaOrder: String): PizzaOrderDTO {
        val orderId = "12345"
        return PizzaOrderDTO(orderId, "$pizzaOrder $orderId")
    }

}

data class PizzaOrderDTO(val orderId: String = "", val pizzaName: String = "")
