package ru.havlong.cards.models

import ru.havlong.cards.transfer.SampleDTO
import javax.persistence.*

@Entity
@Table(name = "sample")
data class Sample(@Id @GeneratedValue(strategy = GenerationType.SEQUENCE) var id: Long?) {

    constructor() : this(null)

    companion object {
        @JvmStatic
        fun from(sample: SampleDTO): Sample = Sample(sample.id)
    }
}
