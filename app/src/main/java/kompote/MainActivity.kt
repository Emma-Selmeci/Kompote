package kompote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kompote.ui.mainmenu.MainMenu
import kompote.ui.mainmenu.getMainMenuItems
import kompote.ui.theme.KompoteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KompoteTheme {
                MainMenu(getMainMenuItems())
            }
        }
    }
}