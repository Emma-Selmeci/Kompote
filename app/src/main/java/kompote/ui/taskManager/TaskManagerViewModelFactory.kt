package kompote.ui.taskManager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kompote.domain.PlanRepository
import kompote.ui.navigation.NavigationIntent
import java.time.LocalDate

class TaskManagerViewModelFactory(
    private val planRepository: PlanRepository,
    private val initialDay: LocalDate,
    private val onNavigation: (NavigationIntent) -> Unit
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskManagerViewModel::class.java)) {
            return TaskManagerViewModel(planRepository, initialDay, onNavigation) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}