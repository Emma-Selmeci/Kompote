package kompote.ui.mainmenu

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class MainMenuItem(
    val name: String,
    val icon: ImageVector,
    val color: Color,
    val onClick: () -> Unit
    )