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

    fun addTaskToDay(day: LocalDate, task: String) {
        val updatedListForDay = _plan.value[day]
            ?.plus(task)
            ?: listOf(task)

        _plan.value = _plan.value + (day to updatedListForDay)

        dataSource.savePlans(_plan.value)
    }
}