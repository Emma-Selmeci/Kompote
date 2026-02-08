package kompote.data.plan

import kompote.domain.event.EventList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class EventSerializer {
    fun serializeEvent(events: EventList) =
        Json.encodeToString<EventList>(events)
}