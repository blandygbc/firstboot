package com.blandygbc.firstboot.backend.domain.product

data class ProductCursorResponse(
    val products: Iterable<Product>,
    val cursor: String?
)
