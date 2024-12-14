package org.st412m.kotlincourse.lesson28.homework.cryptographer

import java.io.File

interface FileProcessor {
    fun findFilesByExtension(extension: String, directory: File): List<File>
    fun encryptFiles(files: List<File>, encryptor: Encryptor)
    fun moveToBackup(files: List<File>, backupDir: File)
}
