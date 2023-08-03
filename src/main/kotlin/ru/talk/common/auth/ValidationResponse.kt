package ru.talk.common.auth

data class ValidationResponse(
    val email: String,
    val userId: Long
)