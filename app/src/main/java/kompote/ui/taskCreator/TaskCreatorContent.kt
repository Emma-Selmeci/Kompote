package kompote.ui.taskCreator

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kompote.ui.theme.KompoteTheme

@Composable
fun TaskCreatorContent(
    uiState: TaskCreatorUiState,
    onEvent: (TaskCreatorEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onEvent(TaskCreatorEvent.Back())
    }
    Scaffold(
        modifier = modifier.systemBarsPadding()
    ) {
        innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            TaskCreatorInnerPadding(
                uiState,
                onEvent
            )
        }
    }
}

@Composable
fun TaskCreatorInnerPadding(
    uiState: TaskCreatorUiState,
    onValueChange: (TaskCreatorEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {onValueChange(TaskCreatorEvent.PreviousDay())}
            ) {
                Text("Previous")
            }
            Text(uiState.dayString)
            Button(
                onClick = {onValueChange(TaskCreatorEvent.NextDay())},
            ) {
                Text("Next")
            }
        }
        TextField(
            value = uiState.taskString,
            onValueChange = { onValueChange(TaskCreatorEvent.TaskNameChange(it)) },
            placeholder = {Text("Task name")}
        )
        TextField(
            value = uiState.taskTime,
            onValueChange = { onValueChange(TaskCreatorEvent.TaskTimeChange(it)) },
            placeholder = {Text("Task time")}
        )
        TextField(
            value = uiState.taskDuration,
            onValueChange = { onValueChange(TaskCreatorEvent.TaskDurationChange(it)) },
            placeholder = {Text("Task duration")}
        )
        Button(
            onClick = {onValueChange(TaskCreatorEvent.SaveTask())}
        ) {
            Text("Save")
        }
    }
}

@Composable
@Preview
fun TaskCreatorContentPreview() {
    KompoteTheme {
        TaskCreatorContent(
            TaskCreatorUiState("2026-03-22","","",""),
            {}
        )
    }
}