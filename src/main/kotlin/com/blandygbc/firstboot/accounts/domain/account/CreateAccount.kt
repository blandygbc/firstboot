package com.blandygbc.firstboot.accounts.domain.account

data class CreateAccount(
    val name : String,
) {
    fun toEntity(): Account = Account(name = this.name)
}