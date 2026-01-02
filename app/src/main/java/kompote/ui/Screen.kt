package kompote.ui

sealed class Screen {
    object Loading: Screen()
    object MainMenu: Screen()
    object TaskListViewer: Screen()
    object TaskCreator: Screen()
}