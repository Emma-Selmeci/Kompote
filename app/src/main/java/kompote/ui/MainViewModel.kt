package kompote.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.TaskListRepository

class MainViewModel: ViewModel() {
    val taskListRepository = TaskListRepository()
    var isInitialized by mutableStateOf(false)

    fun onAppDataReady() {
        isInitialized = true
    }
}