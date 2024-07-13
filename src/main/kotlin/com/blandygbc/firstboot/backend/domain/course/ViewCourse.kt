package com.blandygbc.firstboot.backend.domain.course

data class ViewCourse (
    val id: Long,
    val name: String,
    val studentEnrolledIn : Iterable<String>

)