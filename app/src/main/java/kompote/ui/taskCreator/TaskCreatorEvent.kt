package kompote.ui.taskCreator

sealed class TaskCreatorEvent {
    class SaveTask: TaskCreatorEvent()
    class ValueChange(val taskString: String): TaskCreatorEvent()
    class PreviousDay: TaskCreatorEvent()
    class NextDay: TaskCreatorEvent()
    class Back: TaskCreatorEvent()
}