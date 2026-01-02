package kompote.ui.task_creator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kompote.domain.TaskListRepository

class TaskCreatorViewModelFactory(
    private val repository: TaskListRepository
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskCreatorViewModel::class.java)) {
            return TaskCreatorViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}