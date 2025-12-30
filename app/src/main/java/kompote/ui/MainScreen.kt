package kompote.ui

import androidx.compose.runtime.Composable
import kompote.ui.mainmenu.MainMenu
import kompote.ui.mainmenu.getMainMenuItems
import kompote.ui.misc.LoadingScreen

@Composable
fun MainScreen(viewModel: MainViewModel) {
    if(!viewModel.isInitialized) {
        LoadingScreen()
    } else {
        MainMenu(getMainMenuItems())
    }
}