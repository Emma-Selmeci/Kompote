package kompote.ui.navigation

sealed class Screen {
    object Loading: Screen()
    object MainMenu: Screen()
    object Calendar: Screen()
    object TaskCreator: Screen()
    object TaskManager: Screen()
}