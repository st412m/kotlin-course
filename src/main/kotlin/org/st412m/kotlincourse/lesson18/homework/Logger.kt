package org.st412m.kotlincourse.lesson18.homework

abstract class Logger () {

    fun log(message: String) {
        println("INFO: $message")
    }

    fun log(level: String, message: String) {
        when (level) {
            "WARNING" -> printColored("$level: $message", Colors.YELLOW)
            "ERROR" -> printColored("$level: $message", Colors.WHITE, Background.RED)
            "DEBUG" -> println("DEBUG: $message")
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
