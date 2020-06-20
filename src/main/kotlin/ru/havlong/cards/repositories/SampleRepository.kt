package ru.havlong.cards.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.havlong.cards.models.Sample

interface SampleRepository : JpaRepository<Sample, Long>
