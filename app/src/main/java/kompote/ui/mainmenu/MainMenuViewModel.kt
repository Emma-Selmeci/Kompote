package kompote.ui.mainmenu

import androidx.lifecycle.ViewModel
import kompote.ui.navigation.NavigationIntent
import kompote.ui.navigation.Screen

class MainMenuViewModel(
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModel() {
    fun onAction(action: MainMenuAction) {
        when(action) {
            MainMenuAction.CALENDAR -> onNavigate(NavigationIntent.To(Screen.Calendar))
        }
    }
}