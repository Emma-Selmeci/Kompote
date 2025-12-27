package kompote.ui.mainmenu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color

fun getMainMenuItems(): List<MainMenuItem> = listOf(
    MainMenuItem(
        "Home",
        Icons.Default.Home,
        Color(0xFFAAFF00)
    ) {},
    MainMenuItem(
        "School",
        Icons.Default.DateRange,
        Color(0xFFFFFF33)
    ) {},
    MainMenuItem(
        "On way",
        Icons.Default.LocationOn,
        Color(0xFFFFAA33)
    ) {},
    MainMenuItem(
        "Cooking",
        Icons.Default.ShoppingCart,
        Color(0xFFFF3333)
    ) {},
    MainMenuItem(
        "People",
        Icons.Default.AccountCircle,
        Color(0xFFCF9FFF)
    ) {},
)