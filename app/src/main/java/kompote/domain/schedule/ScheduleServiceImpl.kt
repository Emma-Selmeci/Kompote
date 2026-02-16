package kompote.domain.schedule

import kompote.domain.event.EventRepository
import kompote.domain.task.TaskRepository

class ScheduleServiceImpl(
    private val taskRepository: TaskRepository,
    private val eventRepository: EventRepository,
    private val scheduler: Scheduler,
): ScheduleService {
    override fun onTasksChanged() {
        val events = scheduler.recomputePlan(
            taskRepository.tasks.value.values
        )
        eventRepository.setEvents(events)
    }
}