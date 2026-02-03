package kompote

import android.os.Environment
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kompote.data.plan.DBPlanDataSource
import kompote.data.plan.PlanParser
import kompote.data.plan.PlanSerializer
import kompote.domain.PlanRepository
import java.io.File

class AppInitializer() {
    lateinit var planRepository: PlanRepository private set
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

        planRepository = PlanRepository(
            planDataSource
        )

        planRepository.load()
    }
}