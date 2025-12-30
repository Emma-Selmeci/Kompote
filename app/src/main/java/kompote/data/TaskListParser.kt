package kompote.data

import kompote.domain.model.TaskList
import kotlinx.serialization.json.Json

class TaskListParser {
    fun parseTaskList(str: String): TaskList =
        Json.decodeFromString<TaskList>(str)
}