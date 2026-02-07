package kompote.domain

import kompote.data.plan.FakeTaskIdDataSource
import kompote.domain.task.TaskIdGenerator
import org.junit.Test
import kotlin.test.assertEquals

class TaskIdGeneratorTest {
    @Test
    fun test() {
        val dataSource = FakeTaskIdDataSource(2)
        val taskIdGenerator = TaskIdGenerator(dataSource)
        assertEquals(2L, taskIdGenerator.next())
        assertEquals(3L, dataSource.writtenValue)
        assertEquals(3L, taskIdGenerator.next())
    }
}