package com.blandygbc.firstboot.backend.domain.course

import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course,Long> {
}