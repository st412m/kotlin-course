package org.st412m.kotlincourse.lesson24.homework


fun main() {
    println("----Задание 4-----")
    val value = 30
    if (value <= 20) {
        throw MyFirstException("Ошибка! Значение $value должно быть больше 20!")
    }
    println("Значение прошло проверку!")

    println()
    println("----Задание 5-----")
    try {
        val arrayIndexOut = listOf(1, 2, 3, 4, 5)
        arrayIndexOut[6]
    } catch (e: ArrayIndexOutOfBoundsException) {
        println(println("Произошла ошибка: ${e.message}"))
        throw MySecondRuntimeException(e)
    }
}