package kompote.data.plan

interface PlanDataSource {
    fun loadPlans(): Plan
    fun savePlans(plan: Plan)
}