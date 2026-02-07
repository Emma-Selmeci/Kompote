package kompote.ui.taskManager

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TaskManagerScreen(taskManagerViewModel: TaskManagerViewModel, modifier: Modifier = Modifier) {
    TaskManagerContent(
        taskManagerViewModel.uiState,
        {taskManagerViewModel.onEvent(it)},
        modifier,
    )
}