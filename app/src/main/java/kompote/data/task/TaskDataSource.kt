package kompote.data.task

import kompote.domain.task.TaskList

interface TaskDataSource {
    fun loadTasks(): TaskList
    fun saveTasks(tasks: TaskList)
}