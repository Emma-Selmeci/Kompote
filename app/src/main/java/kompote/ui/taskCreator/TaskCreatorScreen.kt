package kompote.ui.taskCreator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TaskCreatorScreen(taskCreatorViewModel: TaskCreatorViewModel, modifier: Modifier = Modifier) {
    TaskCreatorContent(
        taskCreatorViewModel.uiState,
        {taskCreatorViewModel.onEvent(TaskCreatorEvent.ValueChange(it))},
        {taskCreatorViewModel.onEvent(TaskCreatorEvent.SaveTask())},
        {taskCreatorViewModel.onEvent(TaskCreatorEvent.PreviousDay())},
        {taskCreatorViewModel.onEvent(TaskCreatorEvent.NextDay())},
        {taskCreatorViewModel.onEvent(TaskCreatorEvent.Back())}
    )
}