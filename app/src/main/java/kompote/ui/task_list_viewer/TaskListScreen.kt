package kompote.ui.task_list_viewer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TaskListScreen(
    viewModel: TaskListViewerViewModel,
    modifier: Modifier = Modifier
) {
    val uiState: TaskListViewerUiState = viewModel.uiState
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(uiState.tasksString)
    }
}