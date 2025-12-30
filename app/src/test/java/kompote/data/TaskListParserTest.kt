package kompote.data

import kompote.domain.model.TaskList
import kotlinx.serialization.SerializationException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class TaskListParserTest {
    val parser = TaskListParser()

    @Test
    fun readsEmpty() {
        val emptyTasksString = """{"tasks" : []}"""

        val expected = TaskList(emptyList())
        val result = parser.parseTaskList(emptyTasksString)

        assertEquals(expected, result)
    }

    @Test
    fun readsNotEmpty() {
        val nonEmptyTasksString = """{"tasks" : ["task1", "task2"]}"""

        val expected = TaskList(listOf("task1", "task2"))
        val result = parser.parseTaskList(nonEmptyTasksString)

        assertEquals(expected, result)
    }

    @Test
    fun throwsWhenInvalidJson() {
        val invalidJsonString = """{"""

        assertThrows(SerializationException::class.java) {
            parser.parseTaskList(invalidJsonString)
        }
    }

    @Test
    fun throwsWhenMissingKey() {
        val noTasksKeyJsonString = """{"not-tasks" : ["task1", "task2"]}"""

        assertThrows(SerializationException::class.java) {
            parser.parseTaskList(noTasksKeyJsonString)
        }
    }
}