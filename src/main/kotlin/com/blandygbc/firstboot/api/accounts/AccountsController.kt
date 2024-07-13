package com.blandygbc.firstboot.api.accounts

import com.blandygbc.firstboot.backend.domain.account.Account
import com.blandygbc.firstboot.backend.domain.account.AccountRepository
import com.blandygbc.firstboot.backend.domain.account.CreateAccount
import com.blandygbc.firstboot.backend.domain.account.ViewAccount
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/accounts")
class AccountsController(val accountsRepository: AccountRepository) {

    @GetMapping
    fun getAll(): Iterable<ViewAccount> =
        accountsRepository.findAll().map { it.toView() }


    @PostMapping
    fun create(@RequestBody createAccount: CreateAccount): ViewAccount =
        accountsRepository
            .save(createAccount.toEntity())
            .toView()

    @PostMapping("/search/{item}")
    fun search(@PathVariable item: String): Iterable<ViewAccount> =
        accountsRepository
            .search("%$item%")
            .map { it.toView() }

    @GetMapping("/search-name/{name}")
    fun searchByName(@PathVariable name: String): Iterable<ViewAccount> =
        accountsRepository
            .findByNameLikeIgnoreCase("%$name%")
            .map { it.toView() }
}