package kompote.data.plan

import java.time.LocalDate

interface PlanDataSource {
    fun loadPlans(): Map<LocalDate, List<String>>
    fun savePlans(plans: Map<LocalDate, List<String>>)
}