package com.softwareascraft.eventingswitchlist

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/pizza")
class PizzaOrderController {
    @GetMapping("/addOrder/{pizzaOrder}")
    fun addPizzaOrder(@PathVariable pizzaOrder: String): PizzaOrderDTO {
        return PizzaOrderDTO("12345", pizzaOrder)
    }

}

data class PizzaOrderDTO(val orderId: String = "", val pizzaName: String = "")
