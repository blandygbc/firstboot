package com.blandygbc.firstboot

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogginController {

    val logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/log")
    fun log(): String {
        logger.trace("TRACE line")
        logger.debug("debug line")
        logger.warn("warn line")
        logger.info("INFO {} {}",1,"abc")

        try {
            val x = 1/0
        } catch (e: Throwable){
            logger.error("ERROR failed to compute x",e)
        }

        return "Loggin!"
    }
}