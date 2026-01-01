package kompote.ui

sealed class Screen {
    object MainMenu: Screen()
    object TaskList: Screen()
}