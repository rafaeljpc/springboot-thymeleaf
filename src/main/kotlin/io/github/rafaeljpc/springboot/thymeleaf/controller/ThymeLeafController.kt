package io.github.rafaeljpc.springboot.thymeleaf.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import io.github.rafaeljpc.springboot.thymeleaf.dto.SomeDataDTO
import io.github.rafaeljpc.springboot.thymeleaf.service.IncomeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

private val log = KotlinLogging.logger { }

@Controller
@RequestMapping(path = ["/"])
class ThymeLeafController @Autowired constructor(
    private val service: IncomeService
) {

    @RequestMapping(path = ["/", "/index"], method = [RequestMethod.GET])
    fun mainPage(model: ModelMap) = run {
        log.info { "mainPage" }
        model.addAttribute("allData", service.listData())
        model.addAttribute("countData", service.countData())
        model.addAttribute("someData", SomeDataDTO(nome = "", email = ""))
        "main"
    }

    @PostMapping(path = ["/addData"])
    fun addData(dataDTO: SomeDataDTO, bindingResult: BindingResult, modelMap: ModelMap): String {
        service.addData(dataDTO)
        return "redirect:/index"
    }

}