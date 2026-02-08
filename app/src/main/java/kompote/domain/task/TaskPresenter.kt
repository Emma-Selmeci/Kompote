package kompote.domain.task

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import java.time.LocalDate

class TaskPresenter(
    taskRepository: TaskRepository,
    selectedDate: State<LocalDate>,
) {
    val tasksForDateInOrder: State<List<Task>> = derivedStateOf {
        taskRepository.tasks.value.values
            .filter {
                it.date == selectedDate.value
            }
            .sortedBy {
                it.time
            }
    }
}