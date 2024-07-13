package com.blandygbc.firstboot.backend.domain.course

import com.blandygbc.firstboot.backend.domain.student.Student
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
data class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @ManyToMany
    val studentEnrolledIn: List<Student> = listOf()
){
    fun toView() = ViewCourse(id,name,studentEnrolledIn.map { it.name })
}