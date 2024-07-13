package com.blandygbc.firstboot.backend.domain.student

import com.blandygbc.firstboot.backend.domain.course.Course
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @ManyToMany
    @JoinTable(
        name = "student_enrolled_in_course",
        joinColumns = arrayOf(JoinColumn(name = "student_id")),
        inverseJoinColumns = arrayOf(JoinColumn(name = "course_id"))
    )
    val enrolledIn: List<Course> = listOf()
) {
    fun toView() = ViewStudent(id, name, enrolledIn.map { it.name })
}