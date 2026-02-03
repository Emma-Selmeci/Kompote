package kompote.domain

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import kompote.data.plan.PlanDataSource
import java.time.LocalDate

class PlanRepository(
    private val dataSource: PlanDataSource
) {
    private val _plan = mutableStateOf<Map<LocalDate, List<String>>>(emptyMap())

    fun load() {
        _plan.value = dataSource.loadPlans()
        Log.e("Loading#", _plan.value.toString())
    }
    fun getEventsForDay(day: LocalDate) = _plan.value[day] ?: emptyList()
}