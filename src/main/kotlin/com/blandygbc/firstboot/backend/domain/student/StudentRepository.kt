package com.blandygbc.firstboot.backend.domain.student

import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student,Long> {
}