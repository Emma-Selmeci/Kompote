package kompote.domain.task

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kompote.data.task.TaskDataSource

class TaskRepository(
    private val dataSource: TaskDataSource
) {
    private val _tasks = mutableStateOf<Map<Long, Task>>(emptyMap())
    val tasks: State<Map<Long, Task>> get() = _tasks
    fun load() {
        _tasks.value = dataSource.loadTasks().tasks.associateBy { it.id }
    }
    fun addTask(task: Task) {
        _tasks.value = _tasks.value + (task.id to task)
        dataSource.saveTasks(TaskList(_tasks.value.values.toList()))
    }
    fun removeTask(id: Long) {
        _tasks.value = _tasks.value - id
        dataSource.saveTasks(TaskList(_tasks.value.values.toList()))
    }
}