package ru.havlong.cards.controllers

import org.apache.logging.log4j.LogManager
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    @Throws(Exception::class)
    fun exception(exception: Exception, request: WebRequest): ResponseEntity<Any>? {
        CustomExceptionHandler.logger.error("Exception during execution of application", exception)
        return handleException(exception, request)
    }

    companion object {
        @JvmStatic
        private val logger = LogManager.getLogger(CustomExceptionHandler::class.java)
    }
}
