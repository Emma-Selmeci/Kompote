package kompote.ui.taskManager

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kompote.domain.PlanRepository
import kompote.domain.task.TaskPresenter
import kompote.domain.task.TaskService
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class TaskManagerViewModel(
    planRepository: PlanRepository,
    private val taskService: TaskService,
    initialDay: LocalDate,
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModel() {
    private var currentDay = mutableStateOf(initialDay)
    private val taskPresenter = TaskPresenter(planRepository, currentDay)
    val uiState by derivedStateOf {
        TaskManagerUiState(
            currentDay.value.toString(),
            taskPresenter.selected.value
        )
    }

    fun onEvent(event: TaskManagerEvent) {
        when(event) {
            is TaskManagerEvent.Back -> onNavigate(NavigationIntent.Back)
            is TaskManagerEvent.DeleteEvent -> {
                taskService.removeTaskFromDay(
                    currentDay.value,
                    event.taskId
                )
            }
            is TaskManagerEvent.NextDay -> currentDay.value = currentDay.value.plusDays(1)
            is TaskManagerEvent.PreviousDay -> currentDay.value = currentDay.value.minusDays(1)
        }
    }
}