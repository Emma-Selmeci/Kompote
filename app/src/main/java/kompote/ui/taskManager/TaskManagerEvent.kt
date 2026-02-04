package kompote.ui.taskManager

sealed class TaskManagerEvent {
    class Back: TaskManagerEvent()
    class PreviousDay: TaskManagerEvent()
    class NextDay: TaskManagerEvent()
    class DeleteEvent(val eventString: String): TaskManagerEvent()
}