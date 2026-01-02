package kompote.domain

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kompote.data.FilePaths
import kompote.data.TaskListSerializer
import kompote.data.TextFileWriter
import kompote.domain.model.TaskList
import java.io.File

class TaskListRepository(
    private val rootDirectory: File,
    private val writer: TextFileWriter,
    private val taskListSerializer: TaskListSerializer
) {
    private val taskListMutable = mutableStateOf<List<String>>(emptyList())
    val taskList: State<List<String>> get() = taskListMutable

    fun setTaskList(taskList: TaskList) {
        taskListMutable.value = taskList.tasks
    }

    fun addTask(task: String) {
        taskListMutable.value = taskListMutable.value + task
        writer.writeFile(
            rootDirectory,
            FilePaths.TASK_LIST_PATH,
            taskListSerializer.serialize(TaskList(taskListMutable.value))
        )
    }
}