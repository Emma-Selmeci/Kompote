package kompote.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import kompote.domain.PlanRepository
import kompote.ui.calendar.CalendarScreen
import kompote.ui.calendar.CalendarViewModel
import kompote.ui.calendar.CalendarViewModelFactory
import kompote.ui.mainmenu.MainMenu
import kompote.ui.mainmenu.MainMenuViewModel
import kompote.ui.mainmenu.MainMenuViewModelFactory
import kompote.ui.mainmenu.getMainMenuItems
import kompote.ui.misc.LoadingScreen
import kompote.ui.navigation.Screen
import kompote.ui.navigation.ScreenStateViewModel
import kompote.ui.taskCreator.TaskCreatorScreen
import kompote.ui.taskCreator.TaskCreatorViewModel
import kompote.ui.taskCreator.TaskCreatorViewModelFactory
import kompote.ui.taskManager.TaskManagerScreen
import kompote.ui.taskManager.TaskManagerViewModel
import kompote.ui.taskManager.TaskManagerViewModelFactory
import java.time.LocalDate

@Composable
fun App(
    screenStateViewModel: ScreenStateViewModel,
    planRepository: PlanRepository,
    modifier: Modifier = Modifier
) {
    when(screenStateViewModel.screen) {

        Screen.Loading -> LoadingScreen()

        Screen.MainMenu -> {
            val viewModel: MainMenuViewModel = viewModel(
                factory = MainMenuViewModelFactory(onNavigate = {
                        intent -> screenStateViewModel.navigate(Screen.MainMenu, intent)
                })
            )
            MainMenu(getMainMenuItems(), viewModel::onAction, modifier)
        }

        Screen.Calendar -> {
            val viewModel: CalendarViewModel = viewModel(
                factory = CalendarViewModelFactory(planRepository, LocalDate.now(), onNavigate = {
                        intent -> screenStateViewModel.navigate(Screen.Calendar, intent)
                    })
            )
            CalendarScreen(viewModel, modifier)
        }

        Screen.TaskCreator -> {
            val viewModel: TaskCreatorViewModel = viewModel (
                factory = TaskCreatorViewModelFactory(
                    planRepository,
                    {intent -> screenStateViewModel.navigate(Screen.TaskCreator, intent)},
                    LocalDate.now())
            )
            TaskCreatorScreen(viewModel, modifier)
        }

        Screen.TaskManager -> {
            val viewModel: TaskManagerViewModel = viewModel (
                factory = TaskManagerViewModelFactory(
                    planRepository,
                    LocalDate.now(),
                    {intent -> screenStateViewModel.navigate(Screen.TaskCreator, intent)})
            )
            TaskManagerScreen(viewModel, modifier)
        }
    }
}