package kompote.ui.task_list_viewer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.TaskListRepository

class TaskListViewerViewModel(
    private val taskListRepository: TaskListRepository
): ViewModel() {
    var uiState by mutableStateOf(TaskListViewerUiState(getTasksCsvString()))

    init {
        load()
    }

    fun load() {
        uiState = TaskListViewerUiState(getTasksCsvString())
    }

    private fun getTasksCsvString(): String {
        return taskListRepository.taskList.value.joinToString(", ")
    }
}