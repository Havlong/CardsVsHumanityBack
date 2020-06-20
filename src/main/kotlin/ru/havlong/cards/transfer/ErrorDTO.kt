package ru.havlong.cards.transfer

/**
 * 20.06.2020
 * ErrorDTO
 *
 * @author Havlong
 * @version v1.0
 */
data class ErrorDTO(
        val error: String,
        val errorDescription: String
) {
    companion object {
        @JvmStatic
        fun of(
                error: String,
                errorDescription: String
        ): ErrorDTO = ErrorDTO(error, errorDescription)
    }
}
