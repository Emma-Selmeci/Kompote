package kompote

import android.os.Environment
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kompote.data.plan.DBPlanDataSource
import kompote.data.plan.DBTaskIdDataSource
import kompote.data.plan.PlanParser
import kompote.data.plan.PlanSerializer
import kompote.domain.PlanRepository
import kompote.domain.task.TaskIdGenerator
import kompote.domain.task.TaskService
import kompote.domain.task.TaskServiceImpl
import java.io.File

class AppInitializer() {
    lateinit var planRepository: PlanRepository private set
    lateinit var taskService: TaskService private set
    fun init() {
        val rootDirectory = File(
            Environment.getExternalStorageDirectory(),
            "Kompote"
        )

        val reader = TextFileReader()
        val writer = TextFileWriter()

        val planDataSource = DBPlanDataSource(
            reader,
            writer,
            PlanParser(),
            PlanSerializer(),
            rootDirectory
        )

        val taskIdDataSource = DBTaskIdDataSource(
            reader,
            writer,
            rootDirectory
        )

        val taskIdGenerator = TaskIdGenerator(taskIdDataSource)

        planRepository = PlanRepository(
            planDataSource
        )

        planRepository.load()

        taskService = TaskServiceImpl(
            planRepository, taskIdGenerator
        )
    }
}