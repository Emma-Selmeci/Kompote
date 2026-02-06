package kompote.ui.taskCreator

sealed interface TaskCreatorEvent {
    class SaveTask: TaskCreatorEvent
    class PreviousDay: TaskCreatorEvent
    class NextDay: TaskCreatorEvent
    class Back: TaskCreatorEvent
    class TaskNameChange(val taskString: String): TaskCreatorEvent
    class TaskTimeChange(val taskTimeString: String): TaskCreatorEvent
    class TaskDurationChange(val taskDurationString: String): TaskCreatorEvent

}