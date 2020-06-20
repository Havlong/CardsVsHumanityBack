package ru.havlong.cards.controllers

import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import ru.havlong.cards.services.SampleService
import ru.havlong.cards.transfer.SampleDTO
import javax.transaction.Transactional

@Controller
@Transactional
class SamplesController(private val sampleService: SampleService) {

    @ApiOperation(value = "REST API description here.")
    @GetMapping("/api/samples")
    fun fetchSamples(): ResponseEntity<List<SampleDTO>> {
        val samples = sampleService.getSamples()
        return ResponseEntity.ok(SampleDTO.of(samples))
    }
}
