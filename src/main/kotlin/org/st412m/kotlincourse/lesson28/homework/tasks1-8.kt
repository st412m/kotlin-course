package org.st412m.kotlincourse.lesson28.homework

import java.io.File

fun main() {
    /*
    Создайте текстовый файл workspace/task1/example.txt
    запишите в него строку "Hello, Kotlin!", а затем проверьте, существует ли файл.
    */
    println("\n-----Задача 1-------")
    File("workspace/task1/example.txt").apply {
        parentFile.mkdirs()
        writeText("Hello, Kotlin!")
        println(exists())
    }

    /*
    Создайте директорию workspace/task2/testDir
    проверьте, является ли она директорией, и выведите её абсолютный путь.
     */
    println("\n-----Задача 2-------")
    File("workspace/task2/testDir").apply {
        mkdirs()
        println(isDirectory)
        println(absolutePath)
    }

    /*
    Создайте директорию workspace/task3/structure.
    Внутри директории structure создайте папку myDir с двумя вложенными поддиректориями subDir1 и subDir2.
    Проверьте, что myDir действительно содержит эти поддиректории.
     */
    println("\n-----Задача 3-------")
    val baseDir = File("workspace/task3/structure").apply {
        mkdirs()
    }
    val myDir = File(baseDir, "myDir").apply { mkdirs() }
    val subDirs = listOf("subDir1", "subDir2")
    subDirs.forEach { subDirName ->
        File(myDir, subDirName).mkdirs()
    }

    val allExist = subDirs.all { subDirName ->
        File(myDir, subDirName).isDirectory
    }
    println("Всё создалось: $allExist")

    /*
    Создайте директорию workspace/task4/temp.
    Внутри директории temp создайте несколько вложенных файлов и директорий.
    Удалите директорию workspace/task4 со всем содержимым
     */
    println("\n-----Задача 4-------")
    val tempDir = File("workspace/task4/temp/").apply {
        mkdirs()
    }
    File(tempDir, "file1.txt").writeText("Содержимое 1")
    File(tempDir, "file2.txt").writeText("Содержимое 2")
    File(tempDir, "subDir1").apply { mkdirs() }
    File(tempDir, "subDir1/file3.txt").writeText("Содержимое 3")
    File(tempDir, "subDir2").apply { mkdirs() }
    val files = tempDir.listFiles()
    files?.forEach { file ->
        println(file)
    }
    File("workspace/task4").deleteRecursively()

    /*
    Создайте файл workspace/task5/config/config.txt
    запишите в него список параметров (в формате ключ=значение), а затем прочитайте файл и выведите только значения.
     */
    println("\n-----Задача 5-------")

    val configDir = File("workspace/task5/config").apply { mkdirs() }
    val configFile = File(configDir, "config.txt")

    val parameters = listOf(
        "key1=value1",
        "key2=value2",
        "key3=value3"
    )
    configFile.writeText(parameters.joinToString("\n"))

    val values = configFile.readLines().mapNotNull { it.split("=").getOrNull(1) }
    values.forEach { println(it) }

    /*
    Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов
     */
    println("\n-----Задача 6-------")
    val path = File("workspace")
    println("Пути директорий")
    path.walk()
        .filter { it.isDirectory }
        .forEach { println(it.absolutePath) }
    println("Пути файлов")
    path.walk()
        .filter { it.isFile }
        .forEach { println(it.absolutePath) }

    /*
    Создайте директорию workspace/task9/docs.
    Проверь, есть ли файл с именем readme.md. Если файла нет, создайте его и запишите текст "This is a README file."
     */
    println("\n-----Задача 7-------")
    File("workspace/task9/docs").mkdirs()
    File("workspace/task9/docs/readme.md").apply {
        if (!exists()) {
            writeText("This is a README file.")
            println("Файл создан: $absolutePath")
        } else {
            println("Файл уже существует: $absolutePath")
        }
    }
    /*
    Создайте файлы
    workspace/task10/data/1/4/prod/data14.mysql
    workspace/task10/data/2/3/prod/data23.mysql
    workspace/task10/data/5/2/prod/data52.mysql
    Создайте директорию workspace/task10/backup и скопируйте туда файлы из workspace/task10/data
    сохраняя структуру директорий. Для копирования используй метод copyTo
     */
    println("\n-----Задача 8-------")
    listOf(
        "workspace/task10/data/1/4/prod/data14.mysql",
        "workspace/task10/data/2/3/prod/data23.mysql",
        "workspace/task10/data/5/2/prod/data52.mysql"
    ).forEach { path ->
        File(path).apply {
            parentFile.mkdirs()
            if (!exists()) {
                createNewFile()
                println("Файл создан: $absolutePath")
            } else {
                println("Файл уже существует: $absolutePath")
            }
        }
    }
    val sourceDir = File("workspace/task10/data")
    val targetDir = File("workspace/task10/backup").apply { mkdirs() }

    sourceDir.walk().forEach { file ->
        val relativePath = file.toRelativeString(sourceDir)
        val targetFile = File(targetDir, relativePath)
        if (file.isDirectory) {
            targetFile.mkdirs()
        } else if (file.isFile) {
            file.copyTo(targetFile, overwrite = true)
            println("Файл скопирован: ${file.absolutePath} -> ${targetFile.absolutePath}")
        }
    }
}




