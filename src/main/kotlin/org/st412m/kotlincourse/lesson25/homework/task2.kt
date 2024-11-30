package org.st412m.kotlincourse.lesson25.homework

import org.st412m.kotlincourse.lesson4.numbers
import kotlin.Double
import kotlin.collections.isNotEmpty

/*
Задание 2. Создай функцию, которая принимает список чисел и возвращает среднее арифметическое этого списка.
С помощью require проверь, что список не пустой.
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Создай лямбда выражение без указания типа.
Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).
 */

fun main() {

    val numbers = listOf(1.0, 2.0, 3.0, 4.0)

    val notNullableCheck1 = fun(numbers: List<Double>): Double {
        require(numbers.isNotEmpty()) { "Список не должен быть пустым" }
        return numbers.sum() / numbers.size
    }

    val notNullableCheck2: (List<Double>) -> Double = {
        require(it.isNotEmpty()){ "Список не должен быть пустым" }
        it.sum() / it.size
    }

    val notNullableCheck3 = {
        numbers: List<Double> ->
        require(numbers.isNotEmpty()){ "Список не должен быть пустым" }
        numbers.sum() / numbers.size
    }

    println(notNullableCheck(numbers))
    println(notNullableCheck1(numbers))
    println(notNullableCheck1(numbers))
    println(notNullableCheck1(numbers))

}

fun notNullableCheck(numbers: List<Double>): Double {
    require(numbers.isNotEmpty()) { "Список не должен быть пустым" }
    return numbers.sum() / numbers.size
}