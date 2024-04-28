package com.softwareascraft.eventingswitchlist.status

import com.softwareascraft.eventingswitchlist.senders.MessageSender
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("unit")
class CarStatusControllerTests {
    @Test
    fun `creates CarStatusController`() {
        val messageSender = FakeMessageSender()
        val controller = CarStatusController(messageSender)
        val expectedStatus = CarStatus.EMPTY
        val carId = "12345"
        val rollingStockStatus = controller.getRollingStockStatus(carId)
        assertThat(rollingStockStatus.status).isEqualTo(expectedStatus)
        assertThat(rollingStockStatus.rollingStockId).isEqualTo(carId)
        assertThat(messageSender.sentMessage).isTrue()
    }
}

class FakeMessageSender : MessageSender {
    var sentMessage: Boolean = false

    override fun send(message: String) {
        this.sentMessage = true
    }

}
