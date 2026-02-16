package kompote

import android.os.Environment
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kompote.data.app.DBMetaDataSource
import kompote.data.event.DBEventDataSource
import kompote.data.event.EventParser
import kompote.data.event.EventSerializer
import kompote.data.task.DBTaskDataSource
import kompote.data.task.TaskParser
import kompote.data.task.TaskSerializer
import kompote.domain.event.EventIdGenerator
import kompote.domain.event.EventRepository
import kompote.domain.schedule.ScheduleService
import kompote.domain.schedule.ScheduleServiceImpl
import kompote.domain.schedule.Scheduler
import kompote.domain.task.TaskIdGenerator
import kompote.domain.task.TaskRepository
import kompote.domain.task.TaskService
import kompote.domain.task.TaskServiceImpl
import java.io.File

class AppInitializer() {
    lateinit var eventRepository: EventRepository private set
    lateinit var taskRepository: TaskRepository private set
    lateinit var taskService: TaskService private set
    lateinit var scheduleService: ScheduleService private set
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
        val eventIdGenerator = EventIdGenerator(metaDataSource)

        val scheduler = Scheduler(eventIdGenerator)

        eventRepository = EventRepository(
            eventDataSource
        )

        taskRepository = TaskRepository(
            taskDataSource
        )

        eventRepository.load()
        taskRepository.load()

        scheduleService = ScheduleServiceImpl(
            taskRepository,
            eventRepository,
            scheduler
        )

        taskService = TaskServiceImpl(
            taskRepository,
            scheduleService,
            taskIdGenerator
        )

    }
}