package kompote.data.plan

import java.time.LocalDate

class DBPlanDataSource(): PlanDataSource { //TODO finish this class
    override fun loadPlans(): Map<LocalDate, List<String>> = emptyMap()

    override fun savePlans(plans: Map<LocalDate, List<String>>) {}
}