package ru.havlong.cards.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * 13.06.2020
 * BadRequestException
 *
 * @author Havlong
 * @version v1.0
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Received request was malformed")
class BadRequestException : RuntimeException()