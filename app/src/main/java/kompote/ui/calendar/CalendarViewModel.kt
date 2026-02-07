package kompote.ui.calendar

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kompote.domain.PlanRepository
import kompote.domain.task.TaskPresenter
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class CalendarViewModel(
    planRepository: PlanRepository,
    initialDay: LocalDate,
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModel() {
    private var currentDay = mutableStateOf(initialDay)
    private val taskPresenter = TaskPresenter(planRepository, currentDay)

    val uiState by derivedStateOf {
        CalendarUiState(
        currentDay.value.toString(),
            taskPresenter.selected.value //TODO check if this can be constructed here
    )}

    fun onEvent(event: CalendarEvent) {
        when(event) {
            is CalendarEvent.Back -> onNavigate(NavigationIntent.Back)
            is CalendarEvent.NextDay -> currentDay.value = currentDay.value.plusDays(1)
            is CalendarEvent.PreviousDay -> currentDay.value = currentDay.value.minusDays(1)
        }
    }
}