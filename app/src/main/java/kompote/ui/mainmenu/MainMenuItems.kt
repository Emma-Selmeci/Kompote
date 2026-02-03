package kompote.ui.mainmenu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.Color

fun getMainMenuItems(): List<MainMenuItem> = listOf(
    MainMenuItem(
        "Calendar",
        Icons.Default.DateRange,
        Color(0xFFFFFF33),
        MainMenuAction.CALENDAR
    ),
)