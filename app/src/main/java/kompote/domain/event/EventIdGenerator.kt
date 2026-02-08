package kompote.domain.event

import kompote.data.app.MetaDataSource

class EventIdGenerator(
    private val metaDataSource: MetaDataSource
) {
    private var lastId = metaDataSource.getMetaData().lastEventId
    fun next(): Long {
        val id = lastId++
        metaDataSource.saveLastEventId(lastId)
        return id
    }
}