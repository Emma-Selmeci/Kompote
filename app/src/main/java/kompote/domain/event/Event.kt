package kompote.domain.event

import kompote.data.serializer.DurationSerializer
import kompote.data.serializer.LocalDateSerializer
import kompote.data.serializer.LocalTimeSerializer
import kotlinx.serialization.Serializable
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime

@Serializable
data class Event(
    val id: Long,
    val taskId: Long,
    @Serializable(with = LocalDateSerializer::class)
    val date: LocalDate,
    @Serializable(with = LocalTimeSerializer::class)
    val time: LocalTime,
    @Serializable(with = DurationSerializer::class)
    val duration: Duration
)