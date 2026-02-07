package kompote.domain.task

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import kompote.domain.PlanRepository
import java.time.LocalDate

class TaskPresenter(
    planRepository: PlanRepository,
    date: State<LocalDate> //TODO check if this can be just a param
) {
    val selected: State<List<Task>> = derivedStateOf {
        planRepository.plan.value[date.value]?.values?.sortedBy { it.time } ?: emptyList()
    }
}