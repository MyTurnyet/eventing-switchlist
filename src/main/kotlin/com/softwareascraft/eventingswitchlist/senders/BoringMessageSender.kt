package com.softwareascraft.eventingswitchlist.senders

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger


interface MessageSender {
    fun send(message: String)
}

@Service
class BoringMessageSender(
    @Autowired private val logger: SystemLogger,
    @Autowired private val eventingConnection: EventingConnection,
    @Autowired private val topic: TopicExchange
) : MessageSender {
    private var index: AtomicInteger = AtomicInteger(0)

    private val keys = arrayOf(
        "status.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
        "lazy.rollingStock.fox", "lazy.pink.rollingStock", "status.brown.fox"
    )

    override fun send(message: String) {
        if (this.index.incrementAndGet() == keys.size) {
            this.index.set(0)
        }
        val key = keys[this.index.get()]
        eventingConnection.convertAndSend(topic, key, message)
        val messageSent = " [x] Sent '$message'"
        logger.printLn(messageSent)
    }
}
