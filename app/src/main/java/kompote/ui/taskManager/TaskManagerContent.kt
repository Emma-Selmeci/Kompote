package kompote.ui.taskManager

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kompote.domain.task.Task
import kompote.ui.theme.KompoteTheme
import java.time.Duration
import java.time.LocalTime

@Composable
fun TaskManagerContent(
    uiState: TaskManagerUiState,
    onEvent: (TaskManagerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onEvent(TaskManagerEvent.Back())
    }

    Scaffold(
        modifier = modifier.systemBarsPadding()
    ) {
        innerPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            TaskManagerInnerPadding(
                uiState,
                onEvent
            )
        }
    }
}

@Composable
fun TaskManagerInnerPadding(
    uiState: TaskManagerUiState,
    onEvent: (TaskManagerEvent) -> Unit
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {onEvent(TaskManagerEvent.PreviousDay())}
            ) {
                Text("Previous")
            }
            Text(uiState.dayString)
            Button(
                onClick = {onEvent(TaskManagerEvent.NextDay())}
            ) {
                Text("Next")
            }
        }
        LazyColumn {
            items(uiState.tasks) {
                EventBox(it) {
                    onEvent(TaskManagerEvent.DeleteEvent(it.id))
                }
            }
        }
    }
}

@Composable
fun EventBox(
    event: Task,
    onDelete: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val contentString = "${event.time}: ${event.name} (${event.duration.toMinutes()} min)"
        Text(contentString)
        Button(
            onDelete
        ) {
            Text("Remove event")
        }
    }
}

@Preview
@Composable
fun TaskManagerContentPreview() {
    val taskList = listOf(
        Task(0,"Code", LocalTime.of(11,0), Duration.ofMinutes(60))
    )
    val uiState = TaskManagerUiState("2026-03-22", taskList)
    KompoteTheme {
        TaskManagerContent(
            uiState,
            {}
        )
    }
}