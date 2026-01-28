package kompote.ui.calendar

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.PlanRepository
import kompote.ui.Screen
import java.time.LocalDate

class CalendarViewModel(
    private val planRepository: PlanRepository,
    initialDay: LocalDate,
    private val onNavigate: (Screen) -> Unit
): ViewModel() {

    private var currentDay by mutableStateOf(initialDay)

    val uiState by derivedStateOf {
        CalendarUiState(
        currentDay.toString(),
        planRepository.getEventsForDay(currentDay)
    )}

    fun onEvent(event: CalendarEvent) {
        when(event) {
            is CalendarEvent.Back -> onNavigate(Screen.MainMenu)
            is CalendarEvent.NextDay -> currentDay = currentDay.plusDays(1)
            is CalendarEvent.PreviousDay -> currentDay = currentDay.minusDays(1)
        }
    }
}