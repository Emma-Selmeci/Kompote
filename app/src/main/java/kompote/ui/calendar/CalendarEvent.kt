package kompote.ui.calendar

sealed interface CalendarEvent {
    class PreviousDay : CalendarEvent
    class NextDay : CalendarEvent
    class Back : CalendarEvent
}