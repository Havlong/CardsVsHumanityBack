package ru.havlong.cards.services

import ru.havlong.cards.models.Sample

/**
 * 20.06.2020
 * SampleService
 *
 * @author Havlong
 * @version v1.0
 */
interface SampleService {
    fun getSamples(): List<Sample>
}
