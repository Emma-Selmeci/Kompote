package kompote.data

import java.io.File

class TextFileWriter {
    fun writeFile(rootDirectory: File, filePath: String, fileContent: String) {
        val file = File(rootDirectory, filePath)
        if (!file.exists()) {
            file.parentFile?.mkdirs()
        }
        file.writeText(fileContent)
    }
}