package kompote

import android.os.Environment
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kompote.data.app.DBMetaDataSource
import kompote.data.plan.DBEventDataSource
import kompote.data.plan.EventParser
import kompote.data.plan.EventSerializer
import kompote.data.task.DBTaskDataSource
import kompote.data.task.TaskParser
import kompote.data.task.TaskSerializer
import kompote.domain.event.EventRepository
import kompote.domain.task.TaskIdGenerator
import kompote.domain.task.TaskRepository
import kompote.domain.task.TaskService
import kompote.domain.task.TaskServiceImpl
import java.io.File

class AppInitializer() {
    lateinit var eventRepository: EventRepository private set
    lateinit var taskRepository: TaskRepository private set
    lateinit var taskService: TaskService private set
    fun init() {
        val rootDirectory = File(
            Environment.getExternalStorageDirectory(),
            "Kompote"
        )

        val reader = TextFileReader()
        val writer = TextFileWriter()

        val eventDataSource = DBEventDataSource(
            reader,
            writer,
            EventParser(),
            EventSerializer(),
            rootDirectory
        )

        val taskDataSource = DBTaskDataSource(
            reader,
            writer,
            TaskParser(),
            TaskSerializer(),
            rootDirectory,
        )

        val metaDataSource = DBMetaDataSource(
            reader,
            writer,
            rootDirectory
        )

        val taskIdGenerator = TaskIdGenerator(metaDataSource)

        eventRepository = EventRepository(
            eventDataSource
        )
        taskRepository = TaskRepository(
            taskDataSource
        )

        eventRepository.load()
        taskRepository.load()

        taskService = TaskServiceImpl(
            taskRepository, taskIdGenerator
        )
    }
}