package kompote.data.plan

import kompote.domain.event.EventList

class FakeEventDataSource(
    private val initialData: EventList
): EventDataSource {
    override fun loadEvents() = initialData

    override fun saveEvents(events: EventList) {}
}