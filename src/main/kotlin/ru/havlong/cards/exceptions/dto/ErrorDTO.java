package ru.havlong.cards.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;

    public static ErrorDTO of(String error,
                              String errorDescription) {

        return ErrorDTO.builder()
                .error(error)
                .errorDescription(errorDescription)
                .build();
    }
}