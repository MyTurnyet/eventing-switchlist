package com.softwareascraft.eventingswitchlist

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/status")
class CarStatusController {
    @GetMapping("/rollingStock/{rollingStockId}")
    fun getRollingStockStatus(@PathVariable rollingStockId: String): RollingStockStatus {
        val status = CarStatus.EMPTY
        return RollingStockStatus(rollingStockId, status)
    }

}
enum class CarStatus{
    EMPTY,
    UNKNOWN
}
data class RollingStockStatus(val rollingStockId: String, val status: CarStatus = CarStatus.UNKNOWN)
