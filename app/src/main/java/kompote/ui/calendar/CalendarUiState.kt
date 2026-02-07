package kompote.ui.calendar

import kompote.domain.task.Task

data class CalendarUiState(
    val dayString: String,
    val events: List<Task>
)