package org.st412m.kotlincourse.lesson24

class OrderException(message: String): RuntimeException(message) {  // из нашего исключение передаем сообщение в
// родительский класс исключения
    }