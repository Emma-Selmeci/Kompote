package kompote

import android.os.Environment
import kompote.data.TaskListParser
import kompote.data.TaskListSerializer
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kompote.data.plan.DBPlanDataSource
import kompote.data.plan.PlanParser
import kompote.data.plan.PlanSerializer
import kompote.domain.AppDataLoader
import kompote.domain.PlanRepository
import kompote.domain.TaskListRepository
import java.io.File

class AppInitializer() {
    lateinit var taskListRepository: TaskListRepository private set
    lateinit var planRepository: PlanRepository private set
    fun init() {
        val rootDirectory = File(
            Environment.getExternalStorageDirectory(),
            "Kompote"
        )

        val reader = TextFileReader()
        val writer = TextFileWriter()

        val taskListParser = TaskListParser()
        val taskListSerializer = TaskListSerializer()

        val planDataSource = DBPlanDataSource(
            reader,
            writer,
            PlanParser(),
            PlanSerializer(),
            rootDirectory
        )

        planRepository = PlanRepository(
            planDataSource
        )

        taskListRepository = TaskListRepository(
            rootDirectory,
            writer,
            taskListSerializer
        )

        val loader = AppDataLoader(
            rootDirectory,
            reader,
            taskListParser,
            taskListRepository
        )

        loader.loadAppData()

        planRepository.load()
    }
}