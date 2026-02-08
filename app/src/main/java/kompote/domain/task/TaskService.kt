package kompote.domain.task

import java.time.LocalDate

interface TaskService {
    fun createTask(day: LocalDate, draft: TaskDraft)
    fun removeTask(taskId: Long)
}