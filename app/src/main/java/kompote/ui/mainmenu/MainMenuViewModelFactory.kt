package kompote.ui.mainmenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kompote.ui.navigation.NavigationIntent

class MainMenuViewModelFactory(
    private val onNavigate: (NavigationIntent) -> Unit
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainMenuViewModel::class.java)) {
            return MainMenuViewModel(onNavigate) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}