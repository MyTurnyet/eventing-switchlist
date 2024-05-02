package com.softwareascraft.eventingswitchlist.controllers.status

import com.softwareascraft.eventingswitchlist.senders.MessageSender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/status/rollingStock")
class CarStatusController(@Autowired val messageSender: MessageSender) {

    @GetMapping("/{rollingStockId}")
    fun getRollingStockStatus(@PathVariable rollingStockId: String): ResponseEntity<RollingStockStatus> {
        messageSender.send("getting status for Rolling Stock: ${rollingStockId}")
        var status = CarStatus.EMPTY
        val rollingStockStatus = RollingStockStatus(rollingStockId, status)

        return ResponseEntity.ok(rollingStockStatus)
    }

}

enum class CarStatus {
    EMPTY,
    UNKNOWN
}

data class RollingStockStatus(val rollingStockId: String, val status: CarStatus = CarStatus.UNKNOWN)
