package kompote.data.plan

import kotlinx.serialization.Serializable

@Serializable
data class Plan(
    val plans: List<PlanLine>
)

@Serializable
data class PlanLine(
    val time: String,
    val events: List<String>
)