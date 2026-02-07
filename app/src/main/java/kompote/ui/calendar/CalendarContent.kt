package kompote.ui.calendar

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
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
        CalendarInnerPadding(
            uiState,
            Modifier.padding(it)
        )
    }
}

@Composable
fun CalendarInnerPadding(
    uiState: CalendarUiState,
    modifier: Modifier = Modifier
) {
    val minutesToDp = 2.dp
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {},
        text = {Text("This is a composable")}
    )
    LazyColumn(
        modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)
    ) {
        if(uiState.events.isNotEmpty()) {
            var lastTime = uiState.events[0].time

            uiState.events.forEach { event ->
                val gapMinutes = Duration.between(lastTime, event.time).toMinutes().toInt()
                if (gapMinutes > 0) {
                    item { Spacer(modifier = Modifier.height(gapMinutes * minutesToDp)) }
                }

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(event.duration.toMinutes().toInt() * minutesToDp)
                            .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                            .background(Color(0xFFFF8000), RoundedCornerShape(8.dp))
                    ) {
                        Text(
                            "${event.time}: ${event.name} (${event.duration.toMinutes()} min)",
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }

                lastTime = event.time.plusMinutes(event.duration.toMinutes())
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

@Preview
@Composable
fun CalendarContentPreview() {
    val uiState = CalendarUiState(
        "2026-03-22",
        listOf(
            Task(1L, "Cook lunch", LocalTime.of(11,0), Duration.ofMinutes(45)),
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