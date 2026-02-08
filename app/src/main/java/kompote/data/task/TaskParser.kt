package kompote.data.task

import kompote.domain.task.TaskList
import kotlinx.serialization.json.Json

class TaskParser {
    fun parseTasks(rawData: String) =
        Json.decodeFromString<TaskList>(rawData)

}