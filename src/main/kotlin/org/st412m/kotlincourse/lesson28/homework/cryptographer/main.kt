package org.st412m.kotlincourse.lesson28.homework.cryptographer

import java.io.File

fun main() {

    val sourceDir = File("workspace/task11/data")
    val filesToCreate = listOf(
        "workspace/task11/data/test1.txt",
        "workspace/task11/data/subdir/test2.txt",
        "workspace/task11/data/subdir2/test3.txt"
    )

    filesToCreate.forEach { path ->
        File(path).apply {
            parentFile.mkdirs()
            writeText("проверка шифрования")
            println("Файл создан: $absolutePath")
        }
    }

    val backupDir = File("workspace/task11/backup")
    val processor = FileProcessorImpl()
    val encryptor = EncryptorImpl()
    val manager = EncryptionManager(processor, encryptor)

    manager.encryptFilesInDirectory(sourceDir, backupDir, "txt")
}