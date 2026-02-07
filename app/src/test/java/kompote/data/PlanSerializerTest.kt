package kompote.data

import kompote.data.plan.PlanParser
import kompote.data.plan.PlanSerializer
import kompote.utils.preview.getExamplePlan
import org.junit.Assert.assertEquals
import org.junit.Test
class PlanSerializerTest {
    @Test
    fun test() {
        val plan = getExamplePlan()
        assertEquals(
            plan,
            PlanParser().parsePlan(PlanSerializer().serializePlan(plan))
        )
    }
}