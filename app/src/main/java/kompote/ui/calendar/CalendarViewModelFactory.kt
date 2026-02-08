package kompote.ui.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kompote.domain.event.EventRepository
import kompote.domain.task.TaskRepository
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class CalendarViewModelFactory(
    private val eventRepository: EventRepository,
    private val taskRepository: TaskRepository,
    private val initialDay: LocalDate,
    private val onNavigate: (NavigationIntent) -> Unit
    ): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
            return CalendarViewModel(eventRepository, taskRepository, initialDay, onNavigate) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}