package kompote.data.task

import kompote.domain.task.TaskList

class FakeTaskDataSource(
    private val taskList: TaskList
): TaskDataSource {
    override fun loadTasks() = taskList

    override fun saveTasks(tasks: TaskList) {}
}