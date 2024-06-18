package io.github.rafaeljpc.springboot.thymeleaf.service

import io.github.rafaeljpc.springboot.thymeleaf.dto.SomeDataDTO
import io.github.rafaeljpc.springboot.thymeleaf.repository.IncomeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IncomeService @Autowired constructor(
    private val repository: IncomeRepository
) {

    fun countData() = repository.countData()
    fun listData() = repository.listData()
    fun addData(dataDTO: SomeDataDTO) {
        repository.saveDate(dataDTO)
    }
}