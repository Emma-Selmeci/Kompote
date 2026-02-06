package kompote.ui.taskCreator

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.PlanRepository
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class TaskCreatorViewModel(
    private val planRepository: PlanRepository,
    private val onNavigate: (NavigationIntent) -> Unit,
    initialDay: LocalDate
): ViewModel() {
    private var currentDay by mutableStateOf(initialDay)
    private var taskString by mutableStateOf("")
    private var taskTime by mutableStateOf("")
    private var taskDuration by mutableStateOf("")

    val uiState by derivedStateOf {
        TaskCreatorUiState(
            currentDay.toString(),
            taskString,
            taskTime,
            taskDuration,
        )
    }

    fun onEvent(event: TaskCreatorEvent) {
        when(event) {
            is TaskCreatorEvent.SaveTask -> {
                if(taskString.isNotBlank()) {
                    planRepository.addTaskToDay(
                        currentDay,
                        taskString
                    )
                    taskString = ""
                }
            }
            is TaskCreatorEvent.Back -> onNavigate(NavigationIntent.Back)
            is TaskCreatorEvent.NextDay -> currentDay = currentDay.plusDays(1)
            is TaskCreatorEvent.PreviousDay -> currentDay = currentDay.minusDays(1)
            is TaskCreatorEvent.TaskNameChange -> taskString = event.taskString
            is TaskCreatorEvent.TaskTimeChange -> {
                val str = event.taskTimeString
                if(str.isEmpty() || (str.length < 5 && str.all { it.isDigit() })) {
                    taskTime = str
                }
            }
            is TaskCreatorEvent.TaskDurationChange -> {
                val str = event.taskDurationString
                if(str.isEmpty() || str.all { it.isDigit() }) {
                    taskDuration = str
                }
            }
        }
    }
}