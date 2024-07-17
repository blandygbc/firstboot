package com.blandygbc.firstboot.frontend

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/main")
class MainPageController {
    @GetMapping
    fun index():String{
        return "index"
    }
    @GetMapping("admin")
    fun admin():String{
        return "admin"
    }

}