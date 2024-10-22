package org.st412m.kotlincourse.lesson15.inclass

object Logger {  //  сразу создает готовый объект, к которому можно сразу обращаться. Это и объект и класс
    // одновременно. Существует только в одном экземпляре, в отличие от объектов созданных через Class

    fun log(message: String) {
        println("Log: $message")
    }
}