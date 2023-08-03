package ru.talk.common.exception.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import java.time.ZonedDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ExceptionDto(
    val status: HttpStatus,
    val message: String? = null,
    val stacktrace: StackTraceElement? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    val timestamp: ZonedDateTime = ZonedDateTime.now()
)