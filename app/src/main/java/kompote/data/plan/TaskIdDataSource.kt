package kompote.data.plan

interface TaskIdDataSource {
    fun getLastId(): Long
    fun saveLastId(id: Long)
}