package kompote.data.plan

import android.util.Log
import kompote.data.FilePaths
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kotlinx.serialization.SerializationException
import java.io.File
import java.io.FileNotFoundException

class DBPlanDataSource(
    private val reader: TextFileReader,
    private val writer: TextFileWriter,
    private val parser: PlanParser,
    private val serializer: PlanSerializer,
    private val rootDir: File
): PlanDataSource {
    override fun loadPlans(): Plan {
        try {
            val rawData = reader.readFile(rootDir, FilePaths.PLAN_PATH)
            return parser.parsePlan(rawData)
        } catch(_: FileNotFoundException) {
            return Plan(emptyMap())
        } catch(e: SerializationException) {
            Log.e("Loading#","Error during parsing", e)
            return Plan(emptyMap())
        }
    }

    override fun savePlans(plan: Plan) {
        val serializedData = serializer.serializePlan(plan)
        writer.writeFile(rootDir, FilePaths.PLAN_PATH, serializedData)
    }
}