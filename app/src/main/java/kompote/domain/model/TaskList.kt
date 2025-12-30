package kompote.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TaskList(
    val tasks: List<String>
)