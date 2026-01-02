package kompote.ui.mainmenu

import kompote.ui.Screen

class MainMenuViewModel(
    private val onNavigate: (Screen) -> Unit
) {
    fun onAction(action: MainMenuAction) {
        when(action) {
            MainMenuAction.OPEN_TASK_LIST -> onNavigate(Screen.TaskListViewer)
            MainMenuAction.CREATE_TASK -> onNavigate(Screen.TaskCreator)
        }
    }
}