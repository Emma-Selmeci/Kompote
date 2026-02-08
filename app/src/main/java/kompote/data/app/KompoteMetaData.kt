package kompote.data.app

import kotlinx.serialization.Serializable

@Serializable
data class KompoteMetaData(
    val lastTaskId: Long,
    val lastEventId: Long,
)