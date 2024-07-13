package com.blandygbc.firstboot.api.school

import com.blandygbc.firstboot.backend.domain.course.CourseRepository
import com.blandygbc.firstboot.backend.domain.student.EnrollInCourse
import com.blandygbc.firstboot.backend.domain.student.StudentRepository
import com.blandygbc.firstboot.backend.domain.student.ViewStudent
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/students")
class StudentController(
    val studentRepository: StudentRepository,
    val courseRepository: CourseRepository,
) {
    @GetMapping
    fun findAll(): Iterable<ViewStudent> =
        studentRepository.findAll().map { it.toView() }

    @PostMapping("/enroll/{id}")
    fun enroll(@PathVariable id: Long, @RequestBody enrollInCourse: EnrollInCourse): ViewStudent {
        val student = studentRepository
            .findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        val course = courseRepository
            .findById(enrollInCourse.courseId)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }

        return studentRepository.save(
            student.copy(
                enrolledIn = student.enrolledIn.plus(course)
            )
        ).toView()
    }
}