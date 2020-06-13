package ru.havlong.cards.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * 13.06.2020
 * ForbiddenException
 *
 * @author Havlong
 * @version v1.0
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Service was not available for you")
class ForbiddenException : RuntimeException()