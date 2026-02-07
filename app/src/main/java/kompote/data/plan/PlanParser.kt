package kompote.data.plan

import kotlinx.serialization.json.Json

class PlanParser {
    fun parsePlan(rawData: String) =
        Json.decodeFromString<Plan>(rawData)
}