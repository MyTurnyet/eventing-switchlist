package com.softwareascraft.eventingswitchlist

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/status")
class CarStatusController {
    @GetMapping("/rollingStock/{rollingStockId}")
    fun getRollingStockStatus(@PathVariable rollingStockId: String): RollingStockStatus {
        val status = CarStatus.OK
        return RollingStockStatus(rollingStockId, status)
    }

}
enum class CarStatus{
    OK,
    UNKNOWN
}
data class RollingStockStatus(val rollingStockId: String, val status: CarStatus = CarStatus.UNKNOWN)
