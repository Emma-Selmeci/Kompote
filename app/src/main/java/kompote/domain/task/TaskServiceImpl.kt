package kompote.domain.task

import kompote.data.serializer.localTimeOf
import kompote.domain.PlanRepository
import java.time.Duration
import java.time.LocalDate

class TaskServiceImpl(
    private val planRepository: PlanRepository,
    private val taskIdGenerator: TaskIdGenerator,
): TaskService {
    override fun createTask(day: LocalDate, draft: TaskDraft) {
        val time = localTimeOf(Integer.parseInt(draft.time))
        val duration = Duration.ofMinutes(Integer.parseInt(draft.duration).toLong())

        val task = Task(
            taskIdGenerator.next(),
            draft.name,
            time,
            duration
        )

        planRepository.addTaskToDay(day, task)
    }

    override fun removeTaskFromDay(day: LocalDate, taskId: Long) {
        planRepository.removeTaskFromDay(day, taskId)
    }
}