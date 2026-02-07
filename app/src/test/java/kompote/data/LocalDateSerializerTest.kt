package kompote.data

import kompote.data.serializer.LocalDateSerializer
import kompote.data.serializer.localDateOf
import kompote.data.serializer.toInt
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class LocalDateSerializerTest {
    val serializer = LocalDateSerializer
    @Test
    fun test() {
        val date = LocalDate.of(2026,3,22)

        assertEquals(date, localDateOf(date.toInt()))
    }
}