package kompote.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import kompote.domain.TaskListRepository
import kompote.ui.mainmenu.MainMenu
import kompote.ui.mainmenu.MainMenuViewModel
import kompote.ui.mainmenu.MainMenuViewModelFactory
import kompote.ui.mainmenu.getMainMenuItems
import kompote.ui.misc.LoadingScreen
import kompote.ui.navigation.ScreenStateViewModel
import kompote.ui.task_creator.TaskCreatorScreen
import kompote.ui.task_creator.TaskCreatorViewModel
import kompote.ui.task_creator.TaskCreatorViewModelFactory
import kompote.ui.task_list_viewer.TaskListScreen
import kompote.ui.task_list_viewer.TaskListViewerViewModel
import kompote.ui.task_list_viewer.TaskListViewerViewModelFactory

@Composable
fun App(
    screenStateViewModel: ScreenStateViewModel,
    taskListRepository: TaskListRepository,
) {
    Log.i("Kompote", "Entered App composable")
    when(screenStateViewModel.screen) {

        Screen.Loading -> LoadingScreen()

        Screen.MainMenu -> {
            val viewModel: MainMenuViewModel = viewModel( //viewModel name not recognised
                factory = MainMenuViewModelFactory (screenStateViewModel::navigate)
            )
            MainMenu(getMainMenuItems(), viewModel::onAction)
        }

        Screen.TaskListViewer -> {
            val viewModel: TaskListViewerViewModel = viewModel(
                factory = TaskListViewerViewModelFactory(taskListRepository)
            )
            TaskListScreen(viewModel)
        }

        Screen.TaskCreator -> {
            val viewModel: TaskCreatorViewModel = viewModel(
                factory = TaskCreatorViewModelFactory(taskListRepository)
            )
            TaskCreatorScreen(
                viewModel.uiState,
                viewModel::onClick,
                viewModel::onValueChange,
            )
        }

    }
}