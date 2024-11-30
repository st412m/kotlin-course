package org.st412m.kotlincourse.lesson25.homework
/*
Задание 5. Создай функцию расширение списка чисел, которая будет возвращать список уникальных чисел (без дубликатов).
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
 */

fun main() {
    val listInt = listOf(1, 2, 2, 3, 3, 4, 5)
    val listDouble = listOf(1.1, 2.1, 2.1, 3.1, 3.1, 4.0, 5.2)

    val unique1 = fun List<Number>.(): List<Number> {
        return toSet().toList()
    }

    val unique2: List<Number>.() -> List<Number> = {
        toSet().toList()
    }

    println(listInt.unique())
    println(listDouble.unique())
    println(listInt.unique1())
    println(listDouble.unique1())
    println(listInt.unique2())
    println(listDouble.unique2())

}

fun List<Number>.unique(): List<Number> {
    return toSet().toList()
}