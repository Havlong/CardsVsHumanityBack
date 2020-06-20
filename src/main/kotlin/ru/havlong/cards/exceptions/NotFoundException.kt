package ru.havlong.cards.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * 13.06.2020
 * NotFoundException
 *
 * @author Havlong
 * @version v1.0
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource was not found")
class NotFoundException : RuntimeException()
