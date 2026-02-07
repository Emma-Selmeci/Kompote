package kompote.ui.taskManager

import kompote.domain.task.Task

data class TaskManagerUiState(val dayString: String, val tasks: List<Task>)