package kompote.domain.event

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import kompote.domain.task.TaskRepository
import kompote.ui.calendar.EventUi
import java.time.LocalDate

class EventPresenter(
    private val eventRepository: EventRepository,
    private val taskRepository: TaskRepository,
    date: State<LocalDate>,
) {
    val eventsForDateInOrder: State<List<EventUi>> = derivedStateOf {
        val tasks = taskRepository.tasks.value
        eventRepository.events.value.values
            .filter { it.date == date.value }
            .sortedBy { it.time }
            .mapNotNull { event ->
                val task = tasks[event.taskId] ?: return@mapNotNull null
                EventUi(
                    task.name,event.time, event.duration
                )
            }
    }
}