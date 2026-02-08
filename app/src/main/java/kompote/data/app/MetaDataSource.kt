package kompote.data.app

interface MetaDataSource {
    fun getMetaData(): KompoteMetaData
    fun saveLastEventId(id: Long)
    fun saveLastTaskId(id: Long)
}