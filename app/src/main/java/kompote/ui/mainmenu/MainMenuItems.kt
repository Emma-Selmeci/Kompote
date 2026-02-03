package kompote.ui.mainmenu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.Color

fun getMainMenuItems(): List<MainMenuItem> = listOf(
    MainMenuItem(
        "Calendar",
        Icons.Default.DateRange,
        Color(0xFFFFFF00),
        MainMenuAction.CALENDAR
    ),
    MainMenuItem(
        "Add Task",
        Icons.Default.Add,
        Color(0xFF00FF00),
        MainMenuAction.TASK_CREATOR
    )
)