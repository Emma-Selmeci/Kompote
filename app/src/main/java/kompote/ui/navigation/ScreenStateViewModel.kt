package kompote.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ScreenStateViewModel : ViewModel() {
    var screen by mutableStateOf<Screen>(Screen.MainMenu)
    var isInitialized by mutableStateOf(false)
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

    fun onAppInitialized() {
        isInitialized = true
    }
}