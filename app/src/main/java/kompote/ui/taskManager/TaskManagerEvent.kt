package kompote.ui.taskManager

sealed interface TaskManagerEvent {
    class Back: TaskManagerEvent
    class PreviousDay: TaskManagerEvent
    class NextDay: TaskManagerEvent
    class DeleteEvent(val taskId: Long): TaskManagerEvent
}