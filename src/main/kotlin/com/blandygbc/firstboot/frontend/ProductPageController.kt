package com.blandygbc.firstboot.frontend

import com.blandygbc.firstboot.backend.domain.product.ProductRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/products-page")
class ProductPageController(
    val productRepository: ProductRepository,
) {

    @GetMapping
    fun products(model: Model) : String {
        model.addAttribute("name","Blandy")
        val products = productRepository.findAll(Pageable.unpaged()).toList()
        model.addAttribute(
            "products",
            products
        )
        return "products"
    }
}