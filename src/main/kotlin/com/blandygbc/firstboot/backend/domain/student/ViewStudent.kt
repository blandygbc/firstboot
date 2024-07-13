package com.blandygbc.firstboot.backend.domain.student

data class ViewStudent (
    val id: Long,
    val name: String,
    val enrolledIn : Iterable<String>

)