package kompote.data.app

import kompote.data.FilePaths
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileNotFoundException

class DBMetaDataSource (
    private val reader: TextFileReader,
    private val writer: TextFileWriter,
    private val rootDir: File,
): MetaDataSource {
    private var metaData = load()
    private fun load(): KompoteMetaData {
        try {
            val rawData = reader.readFile(rootDir, FilePaths.METADATA)
            return Json.decodeFromString<KompoteMetaData>(rawData)
        } catch(_: FileNotFoundException) {
            return KompoteMetaData(0, 0)
        }
    }
    private fun save() {
        val rawData = Json.encodeToString<KompoteMetaData>(metaData)
        writer.writeFile(rootDir, FilePaths.METADATA, rawData)
    }

    override fun getMetaData() = metaData

    override fun saveLastTaskId(id: Long) {
        metaData = metaData.copy(lastTaskId = id)
        save()
    }

    override fun saveLastEventId(id: Long) {
        metaData = metaData.copy(lastEventId = id)
        save()
    }
}