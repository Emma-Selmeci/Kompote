package kompote.domain

import kompote.domain.model.TaskList

class TaskListRepository {
    private var taskList: TaskList? = null

    fun setTaskList(taskList: TaskList) {
        this.taskList = taskList
    }

    fun getTaskList(): TaskList =
        taskList ?: error("Tasklist not loaded yet")

}