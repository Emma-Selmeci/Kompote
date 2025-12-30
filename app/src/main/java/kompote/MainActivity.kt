package kompote

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kompote.ui.mainmenu.MainMenu
import kompote.ui.mainmenu.getMainMenuItems
import kompote.ui.misc.LoadingScreen
import kompote.ui.theme.KompoteTheme

private const val REQUEST_CODE_STORAGE = 100
class MainActivity : ComponentActivity() {

    var isReadPermissionGranted by mutableStateOf(false)
    val appInitializer = AppInitializer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if(!checkIsReadPermissionGranted()) {
            requestPermission()
        } else {
            appInitializer.init()
            isReadPermissionGranted = true
        }

        setContent {
            KompoteTheme {
                if (isReadPermissionGranted)
                    MainMenu(getMainMenuItems())
                else
                    LoadingScreen()
            }
        }
    }

    private fun checkIsReadPermissionGranted(): Boolean {
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
                appInitializer.init()
                isReadPermissionGranted = true
            }
        }
    }
}