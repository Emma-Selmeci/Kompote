package kompote.data.event

import kompote.domain.event.EventList
import kotlinx.serialization.json.Json

class EventParser {
    fun parseEvents(rawData: String) =
        Json.decodeFromString<EventList>(rawData)
}