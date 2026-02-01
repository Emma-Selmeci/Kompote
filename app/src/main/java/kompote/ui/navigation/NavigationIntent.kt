package kompote.ui.navigation

sealed interface NavigationIntent {
    data class To(val screen: Screen): NavigationIntent
    data object Back: NavigationIntent
}