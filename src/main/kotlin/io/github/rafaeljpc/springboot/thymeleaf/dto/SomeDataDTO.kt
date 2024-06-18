package io.github.rafaeljpc.springboot.thymeleaf.dto

import java.time.LocalDateTime

data class SomeDataDTO(
    val id: Long? = null,
    val nome: String,
    val email: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
