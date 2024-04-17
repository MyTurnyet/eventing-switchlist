package com.softwareascraft.eventingswitchlist.senders

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import org.springframework.amqp.core.FanoutExchange
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.atomic.AtomicInteger




class MessageSender(
    @Autowired private val logger: SystemLogger,
    @Autowired private val eventingConnection: EventingConnection,
    @Autowired private val fanoutExchange: FanoutExchange
) {
    private var dots: AtomicInteger = AtomicInteger(0)

    private var count: AtomicInteger = AtomicInteger(0)

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send() {
        val builder = StringBuilder("Hello")
        if (dots.getAndIncrement() == 3) {
            dots.set(1)
        }
        for (i in 0 until dots.get()) {
            builder.append('.')
        }
        builder.append(count.incrementAndGet())
        val message = builder.toString()
        eventingConnection.convertAndSend(fanoutExchange, message)
        logger.printLn(" [x] Sent '$message'")
    }
}
