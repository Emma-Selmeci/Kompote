package kompote.utils.preview

import kompote.domain.event.Event
import kompote.domain.event.EventList
import kompote.domain.task.Task
import kompote.domain.task.TaskList
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime

fun getTestTaskListSingleDay() = TaskList(listOf(
    Task(
        0,
        "Eat pizza",
        LocalDate.of(2026,3,22),
        LocalTime.of(9,0),
        Duration.ofMinutes(60)
    ),
    Task(
        1,
        "Code",
        LocalDate.of(2026,3,22),
        LocalTime.of(10,0),
        Duration.ofMinutes(120)
    ),
))
fun getTestTaskListMultipleDays() = TaskList(listOf(
    Task(
        0,
        "Eat pizza",
        LocalDate.of(2026,3,22),
    LocalTime.of(9,0),
        Duration.ofMinutes(60)
    ),
    Task(
        1,
        "Code",
        LocalDate.of(2026,3,22),
        LocalTime.of(10,0),
        Duration.ofMinutes(120)
    ),
    Task(
        2,
        "Cook lunch",
        LocalDate.of(2026,3,24),
        LocalTime.of(8,0),
        Duration.ofMinutes(45)
    ),
))

fun getTestEventListMultipleDays() = EventList(listOf(
    Event(
        0,
        0,
        LocalDate.of(2026,3,22),
        LocalTime.of(9,0),
        Duration.ofMinutes(60)
    ),
    Event(
        1,
        1,
        LocalDate.of(2026,3,22),
        LocalTime.of(10,0),
        Duration.ofMinutes(120)
    ),
    Event(
        2,
        2,
        LocalDate.of(2026,3,24),
        LocalTime.of(8,0),
        Duration.ofMinutes(45)
    ),
))