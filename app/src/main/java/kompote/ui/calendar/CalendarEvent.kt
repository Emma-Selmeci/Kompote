package kompote.ui.calendar

sealed class CalendarEvent {
    class PreviousDay: CalendarEvent()
    class NextDay: CalendarEvent()
    class Back: CalendarEvent()
}