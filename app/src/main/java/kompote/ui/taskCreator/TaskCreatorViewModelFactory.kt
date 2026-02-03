package kompote.ui.taskCreator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kompote.domain.PlanRepository
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class TaskCreatorViewModelFactory (
    private val planRepository: PlanRepository,
    private val onNavigate: (NavigationIntent) -> Unit,
    private val initialDay: LocalDate
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskCreatorViewModel::class.java)) {
            return TaskCreatorViewModel(planRepository, onNavigate, initialDay) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}