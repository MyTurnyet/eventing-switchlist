package com.softwareascraft.eventingswitchlist.controllers.status

import com.softwareascraft.eventingswitchlist.senders.MessageSender
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

@Tag("unit")
class CarStatusControllerTests {
    @Test
    fun `creates CarStatusController`() {
        val messageSender = FakeMessageSender()
        val controller = CarStatusController(messageSender)
        val expectedStatus = CarStatus.EMPTY
        val carId = "12345"
        val rollingStockStatus: ResponseEntity<RollingStockStatus> = controller.getRollingStockStatus(carId)
        assertThat(rollingStockStatus.body?.status).isEqualTo(expectedStatus)
        assertThat(rollingStockStatus.body?.rollingStockId).isEqualTo(carId)
        assertThat(messageSender.sentMessage).isTrue()
    }
}

class FakeMessageSender : MessageSender {
    var sentMessage: Boolean = false

    override fun send(message: String) {
        this.sentMessage = true
    }

}
