package com.softwareascraft.eventingswitchlist.status

import com.softwareascraft.eventingswitchlist.senders.MessageSender
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/status/rollingStock")
class CarStatusController(@Autowired val messageSender: MessageSender) {

    @GetMapping("/{rollingStockId}")
    fun getRollingStockStatus(@PathVariable rollingStockId: String): RollingStockStatus {
        messageSender.send()
        val status = CarStatus.EMPTY
        return RollingStockStatus(rollingStockId, status)
    }

}
enum class CarStatus{
    EMPTY,
    UNKNOWN
}
data class RollingStockStatus(val rollingStockId: String, val status: CarStatus = CarStatus.UNKNOWN)
