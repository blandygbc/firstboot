package com.blandygbc.firstboot.frontend

import com.blandygbc.firstboot.backend.domain.product.Product
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/start")
class MainController {

    @GetMapping
    fun index(model: Model) : String {
        model.addAttribute("name","Blandy")
        model.addAttribute(
            "products",
            listOf(
                Product("Apple",3.99),
                Product("Strawberry",5.99),
                Product("Potato",1.99),
            )
        )
        return "index"
    }
}