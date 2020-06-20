package ru.havlong.cards.transfer

import io.swagger.annotations.ApiModel
import ru.havlong.cards.models.Sample

/**
 * 20.06.2020
 * SampleDTO
 *
 * @author Havlong
 * @version v1.0
 */
@ApiModel(description = "Model description here")
data class SampleDTO(val id: Long?) {
    companion object {
        @JvmStatic
        fun of(entity: Sample): SampleDTO = SampleDTO(entity.id)

        @JvmStatic
        fun of(samples: List<Sample>): List<SampleDTO> = samples.map(Companion::of)
    }
}
