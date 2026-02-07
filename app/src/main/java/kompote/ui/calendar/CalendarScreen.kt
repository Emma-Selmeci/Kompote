package kompote.ui.calendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kompote.data.plan.FakePlanDataSource
import kompote.domain.PlanRepository
import kompote.ui.theme.KompoteTheme
import kompote.utils.preview.getExamplePlan
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

    val repository = PlanRepository(FakePlanDataSource(getExamplePlan()))
    val calendarViewModel: CalendarViewModel = viewModel(
        factory = CalendarViewModelFactory(
            repository,
            LocalDate.of(2026,3,22)
        ) {}
    )
    KompoteTheme {
        CalendarScreen(calendarViewModel)
    }
}
