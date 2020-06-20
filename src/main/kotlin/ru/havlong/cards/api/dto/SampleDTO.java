package ru.havlong.cards.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.havlong.cards.store.entity.Sample;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Describes sample.")
public class SampleDTO {

    private Long id;

    public static SampleDTO of(Sample ent) {

        return SampleDTO.builder()
                .id(ent.getId())
                .build();
    }

    public static List<SampleDTO> of(Stream<Sample> sampleStream) {

        return sampleStream
                .map(SampleDTO::of)
                .collect(Collectors.toList());
    }
}