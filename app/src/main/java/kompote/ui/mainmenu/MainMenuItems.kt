package kompote.ui.mainmenu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.graphics.Color

fun getMainMenuItems(): List<MainMenuItem> = listOf(
    MainMenuItem(
        "View Tasks",
        Icons.Default.DateRange,
        Color(0xFFAAFF00),
        MainMenuAction.OPEN_TASK_LIST
    ),
    MainMenuItem(
        "Add New Task",
        Icons.Default.Add,
        Color(0xFFFFFF33),
        MainMenuAction.CREATE_TASK
    )
)