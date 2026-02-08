package kompote.ui.calendar

import java.time.Duration
import java.time.LocalTime

data class EventUi(
    val name: String,
    val time: LocalTime,
    val duration: Duration,
)