package kompote.ui.calendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kompote.data.plan.FakeEventDataSource
import kompote.data.task.FakeTaskDataSource
import kompote.domain.event.EventRepository
import kompote.domain.task.TaskRepository
import kompote.ui.theme.KompoteTheme
import kompote.utils.preview.getTestEventListMultipleDays
import kompote.utils.preview.getTestTaskListMultipleDays
import java.time.LocalDate

@Composable
fun CalendarScreen(viewModel: CalendarViewModel, modifier: Modifier = Modifier) {
    CalendarContent(
        viewModel.uiState,
        {viewModel.onEvent(it)},
        modifier,
    )
}

@Preview
@Composable
fun CalendarScreenPreview() {
    val eventRepository = EventRepository(FakeEventDataSource(getTestEventListMultipleDays()))
    val taskRepository = TaskRepository(FakeTaskDataSource(getTestTaskListMultipleDays()))
    val calendarViewModel: CalendarViewModel = viewModel(
        factory = CalendarViewModelFactory(
            eventRepository,
            taskRepository,
            LocalDate.of(2026,3,22)
        ) {}
    )
    KompoteTheme {
        CalendarScreen(calendarViewModel)
    }
}
