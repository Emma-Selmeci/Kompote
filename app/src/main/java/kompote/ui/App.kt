package kompote.ui

import androidx.compose.runtime.Composable
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
fun App(
    screenStateViewModel: ScreenStateViewModel,
    mainMenuViewModel: MainMenuViewModel,
    taskListViewerViewModel: TaskListViewerViewModel,
    taskListCreatorViewModel: TaskCreatorViewModel
) { //Do I need to pass down modifiers?
    when(screenStateViewModel.screen) {

        Screen.Loading -> LoadingScreen()

        Screen.MainMenu -> {
            MainMenu(getMainMenuItems(), {mainMenuViewModel.onAction(it)})
        }

        Screen.TaskListViewer -> TaskListScreen(taskListViewerViewModel)

        Screen.TaskCreator -> TaskCreatorScreen(
            taskListCreatorViewModel.uiState,
            {taskListCreatorViewModel.onClick()},
            {taskListCreatorViewModel.onValueChange(it)}
        )

    }
}