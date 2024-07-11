package com.blandygbc.firstboot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class ViewAccount(
    val id: Int,
    val name : String,
)

data class CreateAccount(
    val name : String,
)

@RestController
@RequestMapping("/accounts")
class AccountsController {

    @GetMapping("/hello")
    fun hello(): String = "Hello!"

    @GetMapping
    fun getAll(): Iterable<ViewAccount> {
        return listOf(
            ViewAccount(1,"First")
        )
    }

    @PostMapping
    fun create(createAccount: CreateAccount): ViewAccount {
        return ViewAccount(2,createAccount.name)
    }


}