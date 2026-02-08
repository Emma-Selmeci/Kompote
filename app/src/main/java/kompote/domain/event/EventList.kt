package kompote.domain.event

import kotlinx.serialization.Serializable

@Serializable
data class EventList(val events: List<Event>)