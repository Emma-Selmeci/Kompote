package kompote.ui.calendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kompote.data.plan.FakePlanDataSource
import kompote.domain.PlanRepository
import kompote.ui.theme.KompoteTheme
import java.time.LocalDate

@Composable
fun CalendarScreen(viewModel: CalendarViewModel, modifier: Modifier = Modifier) {
    CalendarContent(
        viewModel.uiState,
        {viewModel.onEvent(CalendarEvent.PreviousDay())},
        {viewModel.onEvent(CalendarEvent.NextDay())},
        {viewModel.onEvent(CalendarEvent.Back())},
        modifier
    )
}

@Preview
@Composable
fun CalendarScreenPreview() {
    val planDataSource = FakePlanDataSource(
        mapOf(
            LocalDate.of(2026,3,22) to listOf("Cook lunch","Learn Kotlin"),
            LocalDate.of(2026,3,23) to listOf("Learn for exam","Terraform Mars")
        ))
    val planRepository = PlanRepository(planDataSource)
    planRepository.load()
    val calendarViewModel: CalendarViewModel = viewModel(
        factory = CalendarViewModelFactory(planRepository, LocalDate.of(2026,3,22)) {}
    )
    KompoteTheme {
        CalendarScreen(calendarViewModel)
    }
}
