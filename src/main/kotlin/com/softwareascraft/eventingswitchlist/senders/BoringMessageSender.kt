package com.softwareascraft.eventingswitchlist.senders

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicInteger


interface MessageSender {
    fun send()
}
@Service
class BoringMessageSender(
    @Autowired private val logger: SystemLogger,
    @Autowired private val eventingConnection: EventingConnection,
    @Autowired private val topic: TopicExchange
): MessageSender {
    private var index: AtomicInteger = AtomicInteger(0)

    private var count: AtomicInteger = AtomicInteger(0)

    private val keys = arrayOf(
        "status.orange.rabbit", "lazy.orange.elephant", "quick.orange.fox",
        "lazy.rollingStock.fox", "lazy.pink.rollingStock", "status.brown.fox"
    )

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    override fun send() {
        val builder = StringBuilder("Hello to ")
        if (this.index.incrementAndGet() === keys.size) {
            this.index.set(0)
        }
        val key = keys[this.index.get()]
        builder.append(key).append(' ')
        builder.append(count.incrementAndGet())
        val message = builder.toString()
        eventingConnection.convertAndSend(topic, key, message)
        println(" [x] Sent '$message'")
    }
}
