package kompote.domain

import androidx.compose.runtime.mutableStateOf
import kompote.data.plan.PlanDataSource
import java.time.LocalDate

class PlanRepository(
    private val dataSource: PlanDataSource
) {
    private val _plan = mutableStateOf<Map<LocalDate, List<String>>>(emptyMap())

    fun load() {
        _plan.value = dataSource.loadPlans()
    }
    fun getEventsForDay(day: LocalDate) = _plan.value[day] ?: emptyList()
}