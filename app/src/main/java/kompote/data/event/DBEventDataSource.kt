package kompote.data.event

import android.util.Log
import kompote.data.FilePaths
import kompote.data.TextFileReader
import kompote.data.TextFileWriter
import kompote.domain.event.EventList
import kotlinx.serialization.SerializationException
import java.io.File
import java.io.FileNotFoundException

class DBEventDataSource(
    private val reader: TextFileReader,
    private val writer: TextFileWriter,
    private val parser: EventParser,
    private val serializer: EventSerializer,
    private val rootDir: File
): EventDataSource {
    override fun loadEvents(): EventList {
        try {
            val rawData = reader.readFile(rootDir, FilePaths.EVENT)
            return parser.parseEvents(rawData)
        } catch(_: FileNotFoundException) {
            return EventList(emptyList())
        } catch(e: SerializationException) {
            Log.e("Loading#","Error during parsing", e)
            return EventList(emptyList())
        }
    }

    override fun saveEvents(events: EventList) {
        val serializedData = serializer.serializeEvent(events)
        writer.writeFile(rootDir, FilePaths.EVENT, serializedData)
    }
}