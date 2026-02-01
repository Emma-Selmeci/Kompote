package kompote.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.PlanRepository
import kompote.domain.TaskListRepository

class ScreenStateViewModel : ViewModel() {
    var screen by mutableStateOf<Screen>(Screen.MainMenu)
    var isInitialized by mutableStateOf(false)
    var taskListRepository: TaskListRepository? by mutableStateOf(null) //TODO check if this is useless
    var planRepository: PlanRepository? by mutableStateOf(null)
    fun navigate(source: Screen, intent: NavigationIntent) {
        screen = when(intent) {
            is NavigationIntent.To -> {
                intent.screen
            }

            is NavigationIntent.Back -> {
                Screen.MainMenu
            }
        }
    }

    fun onAppInitialized(taskListRepository: TaskListRepository, planRepository: PlanRepository) {
        this.taskListRepository = taskListRepository
        this.planRepository = planRepository
        isInitialized = true
    }
}