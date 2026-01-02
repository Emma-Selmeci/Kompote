package kompote.ui.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.ui.Screen

class ScreenStateViewModel : ViewModel() {
    var screen by mutableStateOf<Screen>(Screen.Loading)
    fun navigate(screen: Screen) {
        this.screen = screen
    }
}