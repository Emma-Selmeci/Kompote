package kompote.data.event

import kompote.domain.event.EventList

interface EventDataSource {
    fun loadEvents(): EventList
    fun saveEvents(events: EventList)
}