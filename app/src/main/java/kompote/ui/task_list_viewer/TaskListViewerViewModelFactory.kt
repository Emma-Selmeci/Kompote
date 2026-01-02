package kompote.ui.task_list_viewer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kompote.domain.TaskListRepository

class TaskListViewerViewModelFactory(
    private val repository: TaskListRepository
): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskListViewerViewModel::class.java)) {
            return TaskListViewerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}