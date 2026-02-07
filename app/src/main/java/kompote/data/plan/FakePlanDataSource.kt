package kompote.data.plan

class FakePlanDataSource(
    private val initialData: Plan
): PlanDataSource {
    override fun loadPlans() = initialData

    override fun savePlans(plan: Plan) {}
}