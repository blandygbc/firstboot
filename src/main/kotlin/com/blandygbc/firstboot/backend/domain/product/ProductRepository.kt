package com.blandygbc.firstboot.backend.domain.product

import org.springframework.data.repository.PagingAndSortingRepository

interface ProductRepository: PagingAndSortingRepository<Product,Long> {
}