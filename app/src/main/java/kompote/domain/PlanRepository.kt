package kompote.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kompote.data.plan.Plan
import kompote.data.plan.PlanDataSource
import kompote.domain.task.Task
import java.time.LocalDate

class PlanRepository(
    private val dataSource: PlanDataSource
) {
    private val _plan = mutableStateOf<Map<LocalDate, Map<Long, Task>>>(emptyMap())
    val plan: State<Map<LocalDate, Map<Long, Task>>> get() = _plan
    fun load() {
        _plan.value = dataSource.loadPlans().plans
    }
    fun addTaskToDay(day: LocalDate, task: Task) {
        val updatedMapForDay = _plan.value[day]
            ?.plus(task.id to task)
            ?: mapOf(task.id to task)

        _plan.value = _plan.value + (day to updatedMapForDay)

        dataSource.savePlans(Plan(_plan.value))
    }

    fun removeTaskFromDay(day: LocalDate, taskId: Long) {
        val mapForDay = _plan.value[day] ?: return

        val updatedMapForDay = mapForDay - taskId
        if (updatedMapForDay == mapForDay) return

        _plan.value = if(updatedMapForDay.isEmpty()) {
            _plan.value - day
        } else {
            _plan.value + (day to updatedMapForDay)
        }

        dataSource.savePlans(Plan(_plan.value))
    }
}