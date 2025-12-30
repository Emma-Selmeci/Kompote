package kompote

import android.os.Environment
import kompote.data.TaskListParser
import kompote.data.TextFileReader
import kompote.domain.AppDataLoader
import kompote.domain.TaskListRepository
import java.io.File

class AppInitializer {
    fun init() {
        val rootDirectory = File(
            Environment.getExternalStorageDirectory(),
            "Kompote"
        )

        val textFileReader = TextFileReader()
        val taskListParser = TaskListParser()
        val taskListRepository = TaskListRepository()
        val loader = AppDataLoader(
            rootDirectory,
            textFileReader,
            taskListParser,
            taskListRepository
        )

        loader.loadAppData()
    }
}