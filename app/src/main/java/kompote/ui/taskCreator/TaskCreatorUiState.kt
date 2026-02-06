package kompote.ui.taskCreator

import kompote.domain.task.TaskDraft
import java.time.LocalDate

data class TaskCreatorUiState(
    val currentDay: LocalDate,
    val taskDraft: TaskDraft
)