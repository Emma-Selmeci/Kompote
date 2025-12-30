package kompote.domain

import kompote.data.FilePaths
import kompote.data.TextFileReader
import kompote.data.TaskListParser
import kompote.domain.model.TaskList
import java.io.File

class AppDataLoader(
    private val rootDirectory: File,
    private val textFileReader: TextFileReader,
    private val taskListParser: TaskListParser,
    private val taskListRepository: TaskListRepository
) {
    fun loadAppData() {
        loadTasks(rootDirectory)
    }

    fun loadTasks(rootDirectory: File) {
        try {
            val rawData = textFileReader.readFile(rootDirectory, FilePaths.TASK_LIST_PATH)
            val processedData = taskListParser.parseTaskList(rawData)
            taskListRepository.setTaskList(processedData)
        } catch(e: Exception) {
            val defaultTaskList = TaskList(emptyList())
            taskListRepository.setTaskList(defaultTaskList)
        }
    }
}