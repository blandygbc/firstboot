package com.blandygbc.firstboot.greetings

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class Message(
    val message: String,
    val buildNumber : String,
)

@RestController
@RequestMapping("/greetings")
class GreetingsController(
    @Value("\${blandygbc.firstboot.buildNumber}")
    val buildNumber : String,
) {

    @GetMapping
    fun greet(): Message {
    return Message("Hello!", buildNumber)
    }

    @GetMapping("/hello")
    fun hello(): String = "Hello!"
}