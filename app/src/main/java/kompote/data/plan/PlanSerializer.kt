package kompote.data.plan

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PlanSerializer {
    fun serializePlan(plan: Plan) =
        Json.encodeToString<Plan>(plan)
}