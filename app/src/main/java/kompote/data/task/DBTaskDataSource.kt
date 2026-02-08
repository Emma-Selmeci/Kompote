package kompote.data.task

import android.util.Log
import kompote.data.FilePaths
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kompote.domain.task.TaskList
import kotlinx.serialization.SerializationException
import java.io.File
import java.io.FileNotFoundException

class DBTaskDataSource(
    private val reader: TextFileReader,
    private val writer: TextFileWriter,
    private val parser: TaskParser,
    private val serializer: TaskSerializer,
    private val rootDir: File
): TaskDataSource {
    override fun loadTasks(): TaskList {
        try {
            val rawData = reader.readFile(rootDir, FilePaths.TASK)
            return parser.parseTasks(rawData)
        } catch(_: FileNotFoundException) {
            return TaskList(emptyList())
        } catch(e: SerializationException) {
            Log.e("Loading#","Error during parsing", e)
            return TaskList(emptyList())
        }
    }

    override fun saveTasks(tasks: TaskList) {
        val serializedData = serializer.serializeTasks(tasks)
        writer.writeFile(rootDir, FilePaths.TASK, serializedData)
    }
}