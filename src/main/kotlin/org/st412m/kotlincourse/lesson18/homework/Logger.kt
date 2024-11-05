package org.st412m.kotlincourse.lesson18.homework
/*
Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования
(INFO, WARNING, ERROR, DEBUG)
Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO:
Выполнить перегрузку метода log, который:
Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на
красном фоне.
Принимает список сообщений и все их выводит с уровнем INFO
Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.
 */

class Logger () {

    fun log(message: String) {
        println("INFO: $message")
    }

    fun log(level: String, message: String) {
        when (level) {
            "WARNING" -> printColored("$level: $message", Colors.YELLOW)
            "ERROR" -> printColored("$level: $message", Colors.WHITE, Background.RED)
            "DEBUG" -> printColored("$level: $message", Colors.CYAN)
            else -> println("INFO: $message")
        }
    }

    fun log(messages: List<String>) {
        for (message in messages) {
            log(message)
        }
    }

    fun log(exception: Exception) {
        log("ERROR", exception.message ?: "Случилось непонятное")
    }
}
