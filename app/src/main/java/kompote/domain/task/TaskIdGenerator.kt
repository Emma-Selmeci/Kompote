package kompote.domain.task

import kompote.data.plan.TaskIdDataSource

class TaskIdGenerator(
    private val taskIdDataSource: TaskIdDataSource
) {
    private var lastId = taskIdDataSource.getLastId()
    fun next(): Long {
        val id = lastId++
        taskIdDataSource.saveLastId(lastId)
        return id
    }
}