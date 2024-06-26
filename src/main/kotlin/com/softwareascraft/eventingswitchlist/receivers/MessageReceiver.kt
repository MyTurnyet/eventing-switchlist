package com.softwareascraft.eventingswitchlist.receivers

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.wrappers.StopWatchWrapper
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener


@RabbitListener(queues = ["#{statusQueue1.name}"])
class MessageReceiver(
    private val instanceNumber: Int,
    private val logger: SystemLogger,
    private val stopWatch: StopWatchWrapper,
    private val worker: SleepWorker
) {
    @RabbitHandler
    @Throws(InterruptedException::class)
    fun receiveMessage(message: String) {
        stopWatch.start()
        logger.printLn("instance ${this.instanceNumber} [x] Received '$message'")
        doWork(message)
        stopWatch.stop()
        logger.printLn("instance ${this.instanceNumber} [x] Done in ${stopWatch.totalTimeInSeconds}s")
    }

    @Throws(InterruptedException::class)
    private fun doWork(message: String) {
        logger.printLn("doing work on '$message'")
        worker.workOn(message)
    }

}
