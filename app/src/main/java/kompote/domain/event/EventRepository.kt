package kompote.domain.event

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kompote.data.event.EventDataSource

class EventRepository (
    private val dataSource: EventDataSource
) {
    private val _events = mutableStateOf<Map<Long, Event>>(emptyMap())
    val events: State<Map<Long, Event>> get() = _events
    fun load() {
        _events.value = dataSource.loadEvents().events.associateBy { it.id }
    }

    fun setEvents(newEvents: Collection<Event>) {
        _events.value = newEvents.associateBy { it.id }
        dataSource.saveEvents(EventList(_events.value.values.toList()))
    }
}