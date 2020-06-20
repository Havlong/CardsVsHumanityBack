package ru.havlong.cards.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ru.havlong.cards.exceptions.dto.ErrorDTO;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

@ApiIgnore
@Controller
public class CustomErrorController implements ErrorController {

    private static final Logger logger = LogManager.getLogger();

    static final String PATH = "/error";

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(PATH)
    public ResponseEntity<ErrorDTO> error(WebRequest webRequest) {

        Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest, false);

        return ResponseEntity
                .status((Integer) attributes.get("status"))
                .body(ErrorDTO.of(
                        (String) attributes.get("error"),
                        (String) attributes.get("message"))
                );
    }
}