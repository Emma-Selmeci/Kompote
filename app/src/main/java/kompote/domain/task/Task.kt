package kompote.domain.task

import kompote.data.serializer.DurationSerializer
import kompote.data.serializer.LocalTimeSerializer
import kotlinx.serialization.Serializable
import java.time.Duration
import java.time.LocalTime

@Serializable
data class Task(
    val id: Long,
    val name: String,
    @Serializable(with = LocalTimeSerializer::class)
    val time: LocalTime,
    @Serializable(with = DurationSerializer::class)
    val duration: Duration
)