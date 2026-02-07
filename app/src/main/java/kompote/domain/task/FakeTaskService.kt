package kompote.domain.task

import java.time.LocalDate

class FakeTaskService(
    private val content: Map<LocalDate, List<Task>>
): TaskService {
    override fun createTask(day: LocalDate, draft: TaskDraft) {}
    override fun removeTaskFromDay(day: LocalDate, taskId: Long) {}
}