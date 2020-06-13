package ru.havlong.cards.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * 13.06.2020
 * BackendException
 *
 * @author Havlong
 * @version v1.0
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Request processing on server gone wrong")
class BackendException : RuntimeException()