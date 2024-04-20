package com.softwareascraft.eventingswitchlist

import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/status")
class CarStatusController {
    @GetMapping("/rollingStock/{rollingStockId}")
    fun getRollingStockStatus(@PathVariable rollingStockId: String): RollingStockStatus {
        val status = "OK"
        return RollingStockStatus(rollingStockId, status)
    }

}

data class RollingStockStatus(val rollingStockId: String, val status: String = "UNKOWN")
