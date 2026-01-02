package kompote.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.TaskListRepository
import kompote.ui.Screen

class ScreenStateViewModel : ViewModel() {
    var screen by mutableStateOf<Screen>(Screen.MainMenu)
    var isInitialized by mutableStateOf(false)
    var repository: TaskListRepository? by mutableStateOf(null)
    fun navigate(screen: Screen) {
        this.screen = screen
    }

    fun onAppInitialized(repository: TaskListRepository) {
        this.repository = repository
        isInitialized = true
    }
}