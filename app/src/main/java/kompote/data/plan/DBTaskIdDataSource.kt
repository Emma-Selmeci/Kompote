package kompote.data.plan

import kompote.data.FilePaths
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class DBTaskIdDataSource(
    private val reader: TextFileReader,
    private val writer: TextFileWriter,
    private val rootDir: File,
): TaskIdDataSource {
    override fun getLastId(): Long {
        val rawData = reader.readFile(rootDir, FilePaths.METADATA)
        return Json.decodeFromString<KompoteMetaData>(rawData).lastId
    }

    override fun saveLastId(id: Long) {
        val rawData = Json.encodeToString<KompoteMetaData>(KompoteMetaData(id))
        writer.writeFile(rootDir, FilePaths.METADATA, rawData)
    }
}

@Serializable
data class KompoteMetaData(val lastId: Long)