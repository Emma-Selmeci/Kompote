package kompote.ui.taskCreator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import kompote.data.plan.FakePlanDataSource
import kompote.domain.PlanRepository
import kompote.ui.theme.KompoteTheme
import java.time.LocalDate

@Composable
fun TaskCreatorScreen(taskCreatorViewModel: TaskCreatorViewModel, modifier: Modifier = Modifier) {
    TaskCreatorContent(
        taskCreatorViewModel.uiState,
        taskCreatorViewModel::onEvent,
        modifier
    )
}

@Composable
@Preview
fun TaskCreatorScreenPreview() {
    val planRepository = PlanRepository(FakePlanDataSource(emptyMap()))
    val viewModel: TaskCreatorViewModel = viewModel(
        factory = TaskCreatorViewModelFactory(
            planRepository,
            {},
            LocalDate.of(2026,3,22)
        )
    )
    KompoteTheme {
        TaskCreatorScreen(viewModel)
    }
}