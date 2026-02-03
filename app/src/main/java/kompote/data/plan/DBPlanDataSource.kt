package kompote.data.plan

import android.util.Log
import kompote.data.FilePaths
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kotlinx.serialization.SerializationException
import java.io.File
import java.io.FileNotFoundException
import java.time.LocalDate

class DBPlanDataSource(
    private val reader: TextFileReader,
    private val writer: TextFileWriter,
    private val parser: PlanParser,
    private val serializer: PlanSerializer,
    private val rootDir: File
): PlanDataSource {
    override fun loadPlans(): Map<LocalDate, List<String>> {
        try {
            val rawData = reader.readFile(rootDir, FilePaths.PLAN_PATH)
            return parser.parsePlan(rawData)
        } catch(_: FileNotFoundException) {
            return HashMap()
        } catch(e: SerializationException) {
            Log.e("Loading#","Error during parsing", e)
            return HashMap()
        }
    }

    override fun savePlans(plans: Map<LocalDate, List<String>>) {
        val serializedData = serializer.serializePlan(plans)
        writer.writeFile(rootDir, FilePaths.PLAN_PATH, serializedData)
    }
}