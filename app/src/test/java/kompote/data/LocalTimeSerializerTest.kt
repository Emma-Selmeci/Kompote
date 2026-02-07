package kompote.data

import kompote.data.serializer.localTimeOf
import kompote.data.serializer.toInt
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalTime

class LocalTimeSerializerTest {
    @Test
    fun test() {
        val time = LocalTime.of(9,10)

        assertEquals(time, localTimeOf(time.toInt()))
    }
}