package kompote.domain.task

import kotlinx.serialization.Serializable

@Serializable
data class TaskList(
    val tasks: List<Task>
)