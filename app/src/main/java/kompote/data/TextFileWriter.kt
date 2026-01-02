package kompote.data

import java.io.File
import java.io.FileNotFoundException

class TextFileWriter {
    fun writeFile(rootDirectory: File, filePath: String, fileContent: String) {
        val file = File(rootDirectory, filePath)
        if(!file.exists()) {
            throw FileNotFoundException()
        }
        file.writeText(fileContent)
    }
}