package ru.havlong.cards.services

import org.springframework.stereotype.Service
import ru.havlong.cards.models.Sample
import ru.havlong.cards.repositories.SampleRepository

@Service
class SampleServiceImpl(private val sampleRepository: SampleRepository) : SampleService {
    override fun getSamples(): List<Sample> = sampleRepository.findAll()
}
