package kompote.ui.taskCreator

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.task.TaskService
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class TaskCreatorViewModel(
    initialDay: LocalDate,
    private val service: TaskService,
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModel() {
    private val draftState = TaskDraftState()
    private var currentDay by mutableStateOf(initialDay)
    val uiState by derivedStateOf {
        TaskCreatorUiState(
            currentDay,
            draftState.draft
        )
    }
    fun onEvent(event: TaskCreatorEvent) {
        when(event) {
            is TaskCreatorEvent.SaveTask -> submit()
            is TaskCreatorEvent.Back -> onNavigate(NavigationIntent.Back)
            is TaskCreatorEvent.NextDay -> currentDay = currentDay.plusDays(1)
            is TaskCreatorEvent.PreviousDay -> currentDay = currentDay.minusDays(1)
            is TaskCreatorEvent.TaskNameChange -> draftState.updateName(event.taskString)
            is TaskCreatorEvent.TaskTimeChange -> draftState.updateTime(event.taskTimeString)
            is TaskCreatorEvent.TaskDurationChange -> draftState.updateDuration(event.taskDurationString)
        }
    }
    private fun submit() {
        if(draftState.isSubmittable()) {
            service.createTask(currentDay, draftState.draft)
            draftState.clear()
        }
    }
}