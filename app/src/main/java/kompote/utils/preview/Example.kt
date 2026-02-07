package kompote.utils.preview

import kompote.data.plan.Plan
import kompote.domain.task.Task
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime

fun getExamplePlan(): Plan {
    val task1 = Task(
        1,
        "Cook Lunch",
        LocalTime.of(11,0),
        Duration.ofMinutes(60)
    )

    val task2 = Task(
        2,
        "Code",
        LocalTime.of(12,0),
        Duration.ofMinutes(60)
    )

    val task3 = Task(
        3,
        "Eat pizza",
        LocalTime.of(11,0),
        Duration.ofMinutes(60)
    )

    val map1 = mapOf(
        1L to task1,
        2L to task2,
    )

    val map2 = mapOf(
        3L to task3
    )

    return Plan(mapOf(
        LocalDate.of(2026,3,22) to map1,
        LocalDate.of(2026,3,24) to map2,
    ))
}

fun getExampleEventMap(): Map<LocalDate, List<Task>> {
    val list1 = listOf(
        Task(
            1,
            "Cook Lunch",
            LocalTime.of(11,0),
            Duration.ofMinutes(60)
        ),
        Task(
            2,
            "Code",
            LocalTime.of(12,0),
            Duration.ofMinutes(60)
        )
    )

    val list2 = listOf(
        Task(
            3,
            "Eat pizza",
            LocalTime.of(11,0),
            Duration.ofMinutes(60)
        )
    )

    return mapOf(
        LocalDate.of(2026,3,22) to list1,
        LocalDate.of(2026,3,24) to list2,

        )
}