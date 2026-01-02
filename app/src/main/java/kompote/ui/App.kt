package kompote.ui

import androidx.compose.runtime.Composable
import kompote.domain.TaskListRepository
import kompote.ui.mainmenu.MainMenu
import kompote.ui.mainmenu.MainMenuViewModel
import kompote.ui.mainmenu.getMainMenuItems
import kompote.ui.misc.LoadingScreen
import kompote.ui.navigation.ScreenStateViewModel
import kompote.ui.task_creator.TaskCreatorScreen
import kompote.ui.task_creator.TaskCreatorViewModel
import kompote.ui.task_list_viewer.TaskListScreen
import kompote.ui.task_list_viewer.TaskListViewerViewModel

@Composable
fun App(screenStateViewModel: ScreenStateViewModel, taskListRepository: TaskListRepository) {
    val onNavigate: (Screen) -> Unit = {screenStateViewModel.navigate(it)}
    when(screenStateViewModel.screen) {
        Screen.Loading -> LoadingScreen()
        Screen.MainMenu -> {
            val mainMenuViewModel = MainMenuViewModel(onNavigate)
            MainMenu(getMainMenuItems(), {mainMenuViewModel.onAction(it)})
        }
        Screen.TaskListViewer -> TaskListScreen(TaskListViewerViewModel(taskListRepository).load())
        Screen.TaskCreator -> TaskCreatorScreen(TaskCreatorViewModel(taskListRepository).load())
    }
}