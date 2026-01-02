package kompote.ui.task_creator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
fun TaskCreatorScreen(
    uiState: TaskCreatorUiState,
    onClick: () -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = uiState.taskString,
                onValueChange = onValueChange
            )
            Button(
                onClick = onClick
            ) {
                Text("Save")
            }
        }
    }
}

@Preview
@Composable
fun TaskCreatorScreenPreview() {
    var str by remember { mutableStateOf("Default")}
    KompoteTheme {
        TaskCreatorScreen(
            TaskCreatorUiState(str),
            {},
            {str = it}
        )
    }
}