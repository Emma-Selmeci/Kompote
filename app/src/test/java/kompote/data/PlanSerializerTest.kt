package kompote.data

import kompote.data.plan.PlanSerializer
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class PlanSerializerTest {
    val serializer = PlanSerializer()

    @Test
    fun serializesEmpty() {
        val expected = """{"plans":[]}"""
        val result = serializer.serializePlan(emptyMap())

        assertEquals(expected, result)
    }

    @Test
    fun serializesEmptyDay() {
        val expected = """{"plans":[{"time":"2026-03-22","events":[]}]}"""
        val result = serializer.serializePlan(mapOf(
            LocalDate.of(2026,3,22) to emptyList()
        ))

        assertEquals(expected, result)
    }

    @Test
    fun serializesComplexPlan() {
        val expected = """{"plans":[{"time":"2026-03-22","events":["read books","code"]},{"time":"2026-03-24","events":["eat pizza"]}]}"""
        val result = serializer.serializePlan(mapOf(
            LocalDate.of(2026,3,22) to listOf("read books","code"),
            LocalDate.of(2026,3,24) to listOf("eat pizza"),
        ))

        assertEquals(expected, result)
    }
}