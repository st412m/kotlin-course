package org.st412m.kotlincourse.lesson28.homework.cryptographer

import java.io.File

class FileProcessorImpl() : FileProcessor {
    override fun findFilesByExtension(
        extension: String,
        directory: File,
    ): List<File> {
        TODO("Not yet implemented")
    }

    override fun encryptFiles(
        files: List<File>,
        encryptor: Encryptor,
    ) {
        TODO("Not yet implemented")
    }

    override fun moveToBackup(files: List<File>, backupDir: File) {
        TODO("Not yet implemented")
    }
}