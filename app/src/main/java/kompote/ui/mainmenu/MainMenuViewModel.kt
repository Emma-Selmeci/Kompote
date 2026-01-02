package kompote.ui.mainmenu

import androidx.lifecycle.ViewModel
import kompote.ui.Screen

class MainMenuViewModel(
    private val onNavigate: (Screen) -> Unit
): ViewModel() {
    fun onAction(action: MainMenuAction) {
        when(action) {
            MainMenuAction.OPEN_TASK_LIST -> onNavigate(Screen.TaskListViewer)
            MainMenuAction.CREATE_TASK -> onNavigate(Screen.TaskCreator)
        }
    }
}