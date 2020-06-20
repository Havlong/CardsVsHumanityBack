package ru.havlong.cards.controllers

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.ErrorAttributes
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.context.request.WebRequest
import ru.havlong.cards.transfer.ErrorDTO
import ru.havlong.cards.transfer.ErrorDTO.Companion.of
import springfox.documentation.annotations.ApiIgnore

@ApiIgnore
@Controller
class CustomErrorController(private val errorAttributes: ErrorAttributes) : ErrorController {
    override fun getErrorPath(): String {
        return PATH
    }

    @RequestMapping(PATH)
    fun error(webRequest: WebRequest?): ResponseEntity<ErrorDTO> {
        val attributes = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults()
                .excluding(ErrorAttributeOptions.Include.STACK_TRACE)
        )
        return ResponseEntity
                .status((attributes["status"] as Int?)!!)
                .body(of(
                        (attributes["error"] as String?)!!,
                        (attributes["message"] as String?)!!)
                )
    }

    companion object {
        const val PATH = "/error"
    }

}
