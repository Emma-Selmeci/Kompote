package kompote.data

import kompote.domain.model.TaskList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TaskListSerializer {
    fun serialize(taskList: TaskList): String {
        return Json.encodeToString<TaskList>(taskList)
    }
}