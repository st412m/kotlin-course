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
}

