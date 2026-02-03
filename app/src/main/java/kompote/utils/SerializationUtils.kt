package kompote.utils

import java.time.LocalDate

fun strToLocalDate(str: String): LocalDate {
    return LocalDate.of(
        Integer.parseInt(str.substring(0..3)),
        Integer.parseInt(str.substring(5..6)),
        Integer.parseInt(str.substring(8..9))
    )
}