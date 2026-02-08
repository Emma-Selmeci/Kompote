package kompote.ui.calendar

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kompote.domain.event.EventPresenter
import kompote.domain.event.EventRepository
import kompote.domain.task.TaskRepository
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class CalendarViewModel(
    eventRepository: EventRepository,
    taskRepository: TaskRepository,
    initialDay: LocalDate,
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModel() {
    private var currentDay = mutableStateOf(initialDay)
    private val eventPresenter = EventPresenter(eventRepository, taskRepository, currentDay)

    val uiState by derivedStateOf {
        CalendarUiState(
        currentDay.value.toString(),
            eventPresenter.eventsForDateInOrder.value //TODO check if this can be constructed here
    )}

    fun onEvent(event: CalendarEvent) {
        when(event) {
            is CalendarEvent.Back -> onNavigate(NavigationIntent.Back)
            is CalendarEvent.NextDay -> currentDay.value = currentDay.value.plusDays(1)
            is CalendarEvent.PreviousDay -> currentDay.value = currentDay.value.minusDays(1)
        }
    }
}