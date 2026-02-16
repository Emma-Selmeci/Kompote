package kompote.domain.schedule

import kompote.domain.event.Event
import kompote.domain.event.EventIdGenerator
import kompote.domain.task.Task

class Scheduler(
    private val eventIdGenerator: EventIdGenerator
) {
    fun recomputePlan(tasks: Collection<Task>): List<Event> = emptyList()
}