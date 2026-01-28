package kompote.data.plan

import java.time.LocalDate

class FakePlanDataSource(
    private val initialData: Map<LocalDate, List<String>>
): PlanDataSource {
    override fun loadPlans() = initialData

    override fun savePlans(plans: Map<LocalDate, List<String>>) {}
}