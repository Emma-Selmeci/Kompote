package kompote.data.task

import kompote.domain.task.TaskList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TaskSerializer {
    fun serializeTasks(tasks: TaskList) =
        Json.encodeToString<TaskList>(tasks)
}