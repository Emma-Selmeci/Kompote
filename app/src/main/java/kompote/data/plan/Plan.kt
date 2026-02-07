package kompote.data.plan

import kompote.data.serializer.LocalDateSerializer
import kompote.domain.task.Task
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Plan(
    val plans: Map<
            @Serializable(with = LocalDateSerializer::class) LocalDate,
            Map<Long, Task>>
)