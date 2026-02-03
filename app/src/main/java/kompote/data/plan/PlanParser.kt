package kompote.data.plan

import kompote.utils.strToLocalDate
import kotlinx.serialization.json.Json
import java.time.LocalDate

class PlanParser {
    fun parsePlan(rawData: String): Map<LocalDate, List<String>> {
        val plan = Json.decodeFromString<Plan>(rawData)
        val result = HashMap<LocalDate, List<String>>()
        plan.plans.forEach {
            result.put(
                strToLocalDate(it.time),
                it.events
            )
        }
        return result
    }
}