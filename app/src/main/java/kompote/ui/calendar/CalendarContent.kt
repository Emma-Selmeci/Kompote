package kompote.ui.calendar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kompote.ui.misc.SimpleTopBar
import kompote.ui.theme.KompoteTheme

@Composable
fun CalendarContent(
    uiState: CalendarUiState,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {SimpleTopBar(uiState.dayString,onBackClick)},
        bottomBar = {CalendarBottomBar(onPreviousClick,onNextClick)},
        modifier = modifier.systemBarsPadding()
    ) {
        innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(uiState.events) {
                CalendarEntry(it)
            }
        }
    }
}

@Composable
fun CalendarBottomBar(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onPreviousClick,
            Modifier.weight(1f)
        ) {
            Text("Previous")
        }
        Button(
            onClick = onNextClick,
            Modifier.weight(1f)
        ) {
            Text("Next")
        }
    }
}

@Composable
fun CalendarEntry(content: String) {
    Text(content)
}

@Preview
@Composable
fun CalendarContentPreview() {
    KompoteTheme {
        CalendarContent(
            CalendarUiState(
                "2026.01.23",
                listOf(
                    "Buying books (14:00-15:00)",
                    "Buying books (16:00-17:00)",
                    "Buying books (17:00-18:00)"
                )
            ),
            {},
            {},
            {}
        )
    }
}