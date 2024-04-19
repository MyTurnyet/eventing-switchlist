package com.softwareascraft.eventingswitchlist

class PizzaOrderController {
    fun addPizzaOrder(pizzaOrder: String):PizzaOrderDTO {
        return PizzaOrderDTO("12345", pizzaOrder)
    }

}

data class PizzaOrderDTO (val orderId: String= "", val pizzaName: String= "")
