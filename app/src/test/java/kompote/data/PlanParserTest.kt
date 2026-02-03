package kompote.data

import kompote.data.plan.PlanParser
import kotlinx.serialization.SerializationException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import java.time.LocalDate

class PlanParserTest {
    val parser = PlanParser()

    @Test
    fun readsEmpty() {
        val emptyPlanString = """{"plans" : []}"""

        val expected = emptyMap<LocalDate, List<String>>()
        val result = parser.parsePlan(emptyPlanString)

        assertEquals(expected, result)
    }

    @Test
    fun readsDayWithNoEvents() {
        val planWithDayWithNoEventString = """{"plans" : [{"time" : "2026-03-22", "events" : []}]}"""

        val expected = mapOf(
            LocalDate.of(2026,3,22) to emptyList<String>()
        )
        val result = parser.parsePlan(planWithDayWithNoEventString)

        assertEquals(expected, result)
    }

    @Test
    fun readsComplexPlan() {
        val planWithDayWithNoEventString = """{"plans" : [{"time" : "2026-03-22", "events" : ["read books","code"]}, {"time" : "2026-03-24", "events" : ["eat pizza"]}]}"""

        val expected = mapOf(
            LocalDate.of(2026,3,22) to listOf("read books", "code"),
            LocalDate.of(2026,3,24) to listOf("eat pizza"),
        )
        val result = parser.parsePlan(planWithDayWithNoEventString)

        assertEquals(expected, result)
    }

    @Test
    fun throwsWhenInvalidJson() {
        val invalidJsonString = """{"""

        assertThrows(SerializationException::class.java) {
            parser.parsePlan(invalidJsonString)
        }
    }
}