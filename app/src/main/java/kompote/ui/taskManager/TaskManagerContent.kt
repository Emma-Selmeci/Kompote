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

@Composable
fun TaskManagerContent(
    uiState: TaskManagerUiState,
    onBack: () -> Unit,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onDeleteEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBack()
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
            TaskManagerInnerPadding(
                uiState,
                onPreviousClick,
                onNextClick,
                onDeleteEvent
            )
        }
    }
}

@Composable
fun TaskManagerInnerPadding(
    uiState: TaskManagerUiState,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onDeleteEvent: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onPreviousClick,
            ) {
                Text("Previous")
            }
            Text(uiState.dayString)
            Button(
                onClick = onNextClick,
            ) {
                Text("Next")
            }
        }
        LazyColumn {
            items(uiState.events) {
                EventBox(it) {
                    onDeleteEvent(it)
                }
            }
        }
    }
}

@Composable
fun EventBox(
    eventString: String,
    onDelete: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(eventString)
        Button(
            onDelete
        ) {
            Text("Remove event")
        }
    }
}