package kompote.ui.task_creator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kompote.domain.TaskListRepository

class TaskCreatorViewModel(
    private val taskListRepository: TaskListRepository
): ViewModel() {
    var uiState by mutableStateOf(TaskCreatorUiState(""))

    fun onValueChange(taskString: String) {
        uiState = TaskCreatorUiState(taskString)
    }

    fun onClick() {
        if(uiState.taskString.isEmpty()) return
        taskListRepository.addTask(uiState.taskString)
    }

}