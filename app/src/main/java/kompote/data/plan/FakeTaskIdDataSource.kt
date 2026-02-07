package kompote.data.plan

class FakeTaskIdDataSource(
    private val lastId: Long,
): TaskIdDataSource {
    var writtenValue: Long? = null
    override fun getLastId() = lastId

    override fun saveLastId(id: Long) {
        writtenValue = id
    }
}