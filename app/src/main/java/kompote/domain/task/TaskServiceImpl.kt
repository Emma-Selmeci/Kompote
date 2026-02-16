package kompote.domain.task

import kompote.data.serializer.localTimeOf
import kompote.domain.schedule.ScheduleService
import java.time.Duration
import java.time.LocalDate

class TaskServiceImpl(
    private val taskRepository: TaskRepository,
    private val scheduleService: ScheduleService,
    private val taskIdGenerator: TaskIdGenerator,
): TaskService {
    override fun createTask(day: LocalDate, draft: TaskDraft) {
        val time = localTimeOf(Integer.parseInt(draft.time))
        val duration = Duration.ofMinutes(Integer.parseInt(draft.duration).toLong())

        val task = Task(
            taskIdGenerator.next(),
            draft.name,
            day,
            time,
            duration
        )

        taskRepository.addTask(task)
        scheduleService.onTasksChanged()
    }

    override fun removeTask(taskId: Long) {
        taskRepository.removeTask(taskId)
        scheduleService.onTasksChanged()
    }
}