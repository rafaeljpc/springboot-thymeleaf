package io.github.rafaeljpc.springboot.thymeleaf.service

import io.github.rafaeljpc.springboot.thymeleaf.repository.IncomeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class IncomeService @Autowired constructor(
    private val repository: IncomeRepository
) {

    fun incomeColumnNames() = repository.incomeColumns()
}