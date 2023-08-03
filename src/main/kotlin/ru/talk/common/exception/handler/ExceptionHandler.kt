package ru.talk.common.exception.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import ru.talk.common.exception.dto.ExceptionDto
import ru.talk.common.exception.model.*
import java.time.ZonedDateTime
import java.util.*

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(AlreadyExistsException::class)
    fun alreadyExists(error: AlreadyExistsException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(
            ExceptionDto(
                HttpStatus.CONFLICT,
                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler(NotFoundException::class)
    fun notFound(error: NotFoundException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(
            ExceptionDto(
                HttpStatus.NOT_FOUND,
                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(AuthenticationException::class)
    fun authenticationException(error: AuthenticationException): ResponseEntity<ExceptionDto> {

        return ResponseEntity(
            ExceptionDto(
                HttpStatus.FORBIDDEN,
                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.FORBIDDEN
        )
    }

 @ExceptionHandler(ForbiddenException::class)
    fun forbiddenException(error: ForbiddenException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(
            ExceptionDto(
                HttpStatus.FORBIDDEN,
                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.FORBIDDEN
        )
    }
   
    @ExceptionHandler(InternalException::class)
    fun authException(error: InternalException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(
            ExceptionDto(
                HttpStatus.INTERNAL_SERVER_ERROR,

                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(ConflictException::class)
    fun authException(error: ConflictException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(
            ExceptionDto(
                HttpStatus.CONFLICT,
                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun authException(error: HttpMessageNotReadableException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(
            ExceptionDto(
                HttpStatus.CONFLICT,
                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.CONFLICT
        )
    }

    @ExceptionHandler(ValidationException::class)
    fun constraintViolationException(error: ValidationException): ResponseEntity<ExceptionDto> {
        return ResponseEntity(
            ExceptionDto(
                HttpStatus.BAD_REQUEST,
                error.message,
                error.stackTrace[0],
                ZonedDateTime.now()
            ),
            HttpStatus.BAD_REQUEST
        )
    }
}