package kompote.data

import java.io.File
import java.io.FileNotFoundException

class TextFileReader {
    fun readFile(rootDirectory: File, filePath: String): String {
        val file = File(rootDirectory, filePath)
        if(!file.exists()) {
            throw FileNotFoundException()
        }
        return file.readText()
    }
}