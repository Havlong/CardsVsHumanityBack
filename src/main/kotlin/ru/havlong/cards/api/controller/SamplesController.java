package ru.havlong.cards.api.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.havlong.cards.api.dto.SampleDTO;
import ru.havlong.cards.store.entity.Sample;
import ru.havlong.cards.store.repository.SampleRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

@Controller
@Transactional
@RequiredArgsConstructor
public class SamplesController {

    private final SampleRepository sampleRepository;

    @ApiOperation(value = "Fetch samples method.")
    @GetMapping("/api/samples")
    public ResponseEntity<List<SampleDTO>> fetchSamples() {

        Stream<Sample> sampleStream = sampleRepository.fetchAllSortedStream();

        return ResponseEntity.ok(SampleDTO.of(sampleStream));
    }
}