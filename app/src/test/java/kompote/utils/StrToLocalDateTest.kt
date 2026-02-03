package kompote.utils

import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class StrToLocalDateTest {
    @Test
    fun test() {
        val localDateString = "2025-03-22"

        val expected = LocalDate.of(2025,3,22)
        val result = strToLocalDate(localDateString)

        assertEquals(expected, result)
    }
}