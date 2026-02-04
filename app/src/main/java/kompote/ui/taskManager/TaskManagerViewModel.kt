package kompote.ui.taskManager

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.PlanRepository
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class TaskManagerViewModel(
    private val planRepository: PlanRepository,
    initialDay: LocalDate,
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModel() {
    private var currentDay by mutableStateOf(initialDay)
    val uiState by derivedStateOf {
        TaskManagerUiState(
            initialDay.toString(),
            planRepository.getEventsForDay(currentDay)
        )
    }

    fun onEvent(event: TaskManagerEvent) {
        when(event) {
            is TaskManagerEvent.Back -> onNavigate(NavigationIntent.Back)
            is TaskManagerEvent.DeleteEvent -> {
                planRepository.removeTaskFromDay(
                    currentDay,
                    event.eventString
                )
            }
            is TaskManagerEvent.NextDay -> currentDay = currentDay.plusDays(1)
            is TaskManagerEvent.PreviousDay -> currentDay = currentDay.minusDays(1)
        }
    }
}