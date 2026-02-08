package kompote.ui.taskManager

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kompote.domain.task.TaskPresenter
import kompote.domain.task.TaskRepository
import kompote.domain.task.TaskService
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class TaskManagerViewModel(
    taskRepository: TaskRepository,
    private val taskService: TaskService,
    initialDay: LocalDate,
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModel() {
    private var currentDay = mutableStateOf(initialDay)
    private val taskPresenter = TaskPresenter(taskRepository, currentDay)
    val uiState by derivedStateOf {
        TaskManagerUiState(
            currentDay.value.toString(),
            taskPresenter.tasksForDateInOrder.value
        )
    }

    fun onEvent(event: TaskManagerEvent) {
        when(event) {
            is TaskManagerEvent.Back -> onNavigate(NavigationIntent.Back)
            is TaskManagerEvent.DeleteEvent -> {
                taskService.removeTask(
                    event.taskId
                )
            }
            is TaskManagerEvent.NextDay -> currentDay.value = currentDay.value.plusDays(1)
            is TaskManagerEvent.PreviousDay -> currentDay.value = currentDay.value.minusDays(1)
        }
    }
}