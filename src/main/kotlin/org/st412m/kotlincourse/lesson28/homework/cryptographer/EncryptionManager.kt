package org.st412m.kotlincourse.lesson28.homework.cryptographer

import java.io.File

class EncryptionManager(private val fileProcessor: FileProcessor, private val encryptor: Encryptor) {
    fun encryptFilesInDirectory(directory: File, backupDir: File, extension: String) {
        val files = fileProcessor.findFilesByExtension(extension, directory)
        fileProcessor.moveToBackup(files, backupDir)
        fileProcessor.encryptFiles(files, encryptor)
    }
}