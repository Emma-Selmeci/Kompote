package kompote.ui.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kompote.domain.PlanRepository
import kompote.ui.Screen
import java.time.LocalDate

class CalendarViewModelFactory(
    private val repository: PlanRepository,
    private val initialDay: LocalDate,
    private val onNavigate: (Screen) -> Unit
    ): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
            return CalendarViewModel(repository, initialDay, onNavigate) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}