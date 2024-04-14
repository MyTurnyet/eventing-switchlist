package com.softwareascraft.eventingswitchlist.receivers

import com.softwareascraft.eventingswitchlist.logging.SystemLogger
import com.softwareascraft.eventingswitchlist.wrappers.StopWatchWrapper
import org.springframework.amqp.rabbit.annotation.RabbitHandler


class MessageReceiver(
    private val instanceNumber: Int,
    private val logger: SystemLogger,
    private val stopWatch: StopWatchWrapper
) {
    @RabbitHandler
    @Throws(InterruptedException::class)
    fun receiveMessage(message: String) {
        stopWatch.start()
        logger.printLn("instance ${this.instanceNumber} [x] Received '$message'")
//        doWork(message)
    stopWatch.stop()
//        logger.printLn(
//            (("instance " + this.instanceNumber) +
//                    " [x] Done in " + watch.totalTimeSeconds + "s")
//        )
    }

    @Throws(InterruptedException::class)
    private fun doWork(`in`: String) {
        for (ch in `in`.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000)
            }
        }
    }

}
