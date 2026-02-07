package kompote.ui.calendar

import androidx.activity.compose.BackHandler
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
import kompote.domain.task.Task
import kompote.ui.misc.SimpleTopBar
import kompote.ui.theme.KompoteTheme
import java.time.Duration
import java.time.LocalTime

@Composable
fun CalendarContent(
    uiState: CalendarUiState,
    onEvent: (CalendarEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    BackHandler {
        onEvent(CalendarEvent.Back())
    }
    Scaffold(
        topBar = {SimpleTopBar(
            uiState.dayString,
            {onEvent(CalendarEvent.Back())}
        )},
        bottomBar = {CalendarBottomBar(
            {onEvent(CalendarEvent.PreviousDay())},
            {onEvent(CalendarEvent.NextDay())}
        )},
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
fun CalendarEntry(content: Task) {
    val contentString = "${content.time}: ${content.name} (${content.duration.toMinutes()} min)"
    Text(contentString)
}

@Preview
@Composable
fun CalendarContentPreview() {
    val uiState = CalendarUiState(
        "2026-03-22",
        listOf(
            Task(1L, "Cook lunch", LocalTime.of(11,0), Duration.ofMinutes(60)),
            Task(2L, "Code", LocalTime.of(12,0), Duration.ofMinutes(15)),
        )
    )
    KompoteTheme {
        CalendarContent(
            uiState,
            {}
        )
    }
}