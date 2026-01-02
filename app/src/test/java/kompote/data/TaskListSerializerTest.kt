package kompote.data

import kompote.domain.model.TaskList
import org.junit.Assert.assertEquals
import org.junit.Test

class TaskListSerializerTest {

    val serializer = TaskListSerializer()

    @Test
    fun serializesNotEmpty() {
        val taskList = TaskList(listOf("task1","task2"))

        val expected = """{"tasks":["task1","task2"]}"""
        val result = serializer.serialize(taskList)

        assertEquals(expected, result)
    }

}