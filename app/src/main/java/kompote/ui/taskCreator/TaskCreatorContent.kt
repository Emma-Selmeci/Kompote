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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kompote.ui.theme.KompoteTheme

@Composable
fun TaskCreatorContent(
    uiState: TaskCreatorUiState,
    onValueChange: (String) -> Unit,
    onSave: () -> Unit,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackClick()
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
                onValueChange,
                onSave,
                onPreviousClick,
                onNextClick
            )
        }
    }
}

@Composable
fun TaskCreatorInnerPadding(
    uiState: TaskCreatorUiState,
    onValueChange: (String) -> Unit,
    onSave: () -> Unit,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
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
        TextField(
            value = uiState.taskString,
            onValueChange = onValueChange
        )
        Button(
            onClick = onSave
        ) {
            Text("Save")
        }
    }
}

@Composable
@Preview
fun TaskCreatorContentPreview() {
    var str by remember { mutableStateOf("") }
    KompoteTheme {
        TaskCreatorContent(
            TaskCreatorUiState("2026-03-22",str),
            {str = it},
            {},
            {},
            {},
            {}
        )
    }
}