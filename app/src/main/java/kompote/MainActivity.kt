package kompote

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kompote.domain.TaskListRepository
import kompote.ui.App
import kompote.ui.Screen
import kompote.ui.navigation.ScreenStateViewModel
import kompote.ui.theme.KompoteTheme

private const val REQUEST_CODE_STORAGE = 100
class MainActivity : ComponentActivity() {

    private val screenStateViewModel: ScreenStateViewModel by viewModels()
    private val taskListRepository = TaskListRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if(hasPermission()) {
            AppInitializer(taskListRepository).init()
            screenStateViewModel.navigate(Screen.MainMenu)
        } else {
            requestPermission()
        }

        setContent {
            KompoteTheme {
                App(screenStateViewModel, taskListRepository)
            }
        }
    }

    private fun hasPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_CODE_STORAGE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_STORAGE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                AppInitializer(taskListRepository).init()
                screenStateViewModel.navigate(Screen.MainMenu)
            }
        }
    }
}