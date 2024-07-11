package com.blandygbc.firstboot.accounts.domain.account

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AccountRepository: CrudRepository<Account,Long> {
    fun findByNameStartingWith(prefix: String) : Iterable<Account>

    @Query("SELECT a FROM Account a WHERE a.name LIKE :item")
    fun search(item: String) : Iterable<Account>

    fun findByNameLikeIgnoreCase(name:String): Iterable<Account>
}