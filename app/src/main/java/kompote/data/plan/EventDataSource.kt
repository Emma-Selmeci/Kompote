package kompote.data.plan

import kompote.domain.event.EventList

interface EventDataSource {
    fun loadEvents(): EventList
    fun saveEvents(events: EventList)
}