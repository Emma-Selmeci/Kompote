package kompote.domain.task

import java.time.LocalDate

interface TaskService {
    fun createTask(day: LocalDate, draft: TaskDraft)
    fun removeTaskFromDay(day: LocalDate, taskId: Long)
}