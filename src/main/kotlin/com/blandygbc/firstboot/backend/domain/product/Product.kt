package com.blandygbc.firstboot.backend.domain.product

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity(name = "Product")
@Table(name = "products", schema = "public")
data class Product(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @field:NotBlank
    @field:Size(min = 3, max = 30)
    val name: String,
    @field:NotNull
    @field:Size(min = 0)
    val price: Double,
)