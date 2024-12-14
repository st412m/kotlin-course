package org.st412m.kotlincourse.lesson28.homework.cryptographer

import java.io.File

class FileProcessorImpl() : FileProcessor {
    override fun findFilesByExtension(extension: String, directory: File): List<File> {
        val files = mutableListOf<File>()
        directory.walk().forEach {
            if (it.isFile && it.extension == extension) {
                files.add(it)
            }
        }
        return files
    }

    override fun encryptFiles(files: List<File>, encryptor: Encryptor) {
        files.forEach { file ->
            val content = file.readText()
            val encryptedContent = encryptor.encrypt(content)
            file.writeText(encryptedContent)
        }
    }

    override fun moveToBackup(files: List<File>, backupDir: File) {
        files.forEach { file ->
            val relativePath = file.toRelativeString(backupDir.parentFile)
            val backupFile = File(backupDir, relativePath)
            backupFile.parentFile.mkdirs()
            file.copyTo(backupFile, overwrite = true)
        }
    }
}
