package org.st412m.kotlincourse.lesson28

import java.io.File

fun main() {
    val map = mapOf("один" to 1.0, "два" to 2.0, "три" to 3.0)
    writeDataToFile(map, "path/folder1/folder2/file.txt")
    println(readFileToMap("path/folder1/folder2/file.txt"))
}

fun createFileOrDirectory(path: String) {
    File(path).apply {
        if (path.endsWith("/")) {
            mkdirs()
        } else {
            parentFile.mkdirs()
            createNewFile()
        }
    }
}

fun writeDataToFile(data: Map<String, Double>, path: String) {
    val str = data.map { "${it.key}=${it.value}" }.joinToString("\n")
    createFileOrDirectory(path)
    File(path).writeText(str)
}

fun readFileToMap(path: String): Map<String, Double> {
    val file = File(path).readLines()
    return file.associate {
        val parts = it.split("=")
        parts[0] to parts[1].toDouble()
    }
}