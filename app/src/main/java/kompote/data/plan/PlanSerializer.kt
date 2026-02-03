package kompote.data.plan

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.LocalDate

class PlanSerializer {
    fun serializePlan(plan: Map<LocalDate, List<String>>): String {
        return Json.encodeToString<Plan>(
            Plan(
                plan.map { (key, value) ->
                    PlanLine(key.toString(), value)
                }
            )
        )
    }
}