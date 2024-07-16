package com.blandygbc.firstboot.api.product

import com.blandygbc.firstboot.backend.domain.product.Product
import com.blandygbc.firstboot.backend.domain.product.ProductCursorResponse
import com.blandygbc.firstboot.backend.domain.product.ProductRepository
import com.blandygbc.firstboot.backend.utils.PageUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(
    val productRepository: ProductRepository,
) {
    @GetMapping("/top")
    fun topProducts(
        @RequestParam(name = "pageNumber",defaultValue = "0") pageNumber:Int,
        @RequestParam(name = "pageSize",defaultValue = "5") pageSize:Int,
        ): Page<Product> =
        productRepository.findAll(
            PageRequest.of(
                pageNumber,
                pageSize,
                Sort
                    .by("price")
                    .descending()
                    .and(Sort.by("id"))
            )
        )

    @GetMapping("/top-cursor")
    fun topProductsCusor(
        @RequestParam cursor:String?,
        @RequestParam(name = "pageSize",defaultValue = "5") pageSize:Int,
    ) =
        productRepository.findAll(
            cursor?.let { PageUtils.fromCursor(it) }
                ?:PageUtils.firstPage(pageSize)
        ).let {
            ProductCursorResponse(
                products = it.toList(),
                cursor = if(it.hasNext()) PageUtils.createCursor(it.nextPageable()) else null

            )
        }
}