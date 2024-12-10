package org.st412m.kotlincourse.lesson28

import java.io.File

fun main() {
    val file = File("path/to/your/file.txt")  // и это и то что ниже может быть как файлом, так и директорией, то что
    // написано в кавычках пока значения не имеет
    val directory = File("path/to/your/")

    file.parentFile.mkdirs()  // создание директорий, т.е. создастся весь путь "path/to/your" если написать mkdir то
    // будет создавать по одной диркетории за раз

    val isNewFileCreated: Boolean = file.createNewFile()
    if (isNewFileCreated) {
        println("Файл был создан")
    } else {
        println("Файл уже существует")
    }

    if (file.exists()) {
        println("Файл существует")
    } else {
        println("Файл не найден")
    }

    file.writeText("Hello, world!") // очищает содержимое файла и перезаписывает полностью
    val text = file.readText()
    println(text)

    val files = directory.listFiles()
    files?.forEach { file ->
        println(file.name) // file.name выведет прямо название файла, если без просто file, то будет выведено
    // название, включая путь
    }
    (1..5).forEach {  // создаем папки в цикле
        file.parentFile.resolve("$it").mkdirs()
    }

    if (file.delete()) {
        println("Файл удален")
    } else {
        println("Не удалось удалить файл")
    }

    if (file.deleteRecursively()) {  // удалит всё с директориями вместе
        println("Директория и всё её содержимое удалено")
    } else {
        println("Не удалось удалить директорию")
    }

    file.walk().filter { it.isFile }  // открываем поток(walk) файловой системы, фильтруем и ищем только файлы, далее
        .associateWith {it.readLines() } // методом associate превращаем поток в словарь, где ключ - имя
        // файла, а значение - содержимое
        .filterValues { data ->  // фильтруем строки, где в содержимом есть слово "text"
            data.any {it.contains("text")}
        }

    println(file.absoluteFile) // покажет полный путь до файла, включая его имя(D:\skjdfsk\kdsjfks\file.txt - в
// случае с виндой, например)

    val t: String = file.parent  // возвращает строку
    val k: File = file.parentFile // возвращает объект, который хранит путь

    val baseDir = File("path/to")
    val file1 = File("path/to/nested/file.txt")
    val relative = file1.toRelativeString(baseDir) // позволяет скопировать в другую ветку сохраняя структуру "path/to/nested/file.txt"
    println(file1.toRelativeString(baseDir))
    val baseDir2 = File("path2/to")
    val file3 = baseDir2.resolve(relative)
    file3.parentFile.mkdirs()
    file3.createNewFile()
}