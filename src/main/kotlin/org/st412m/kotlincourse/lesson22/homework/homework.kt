package org.st412m.kotlincourse.lesson22.homework

import org.st412m.kotlincourse.lesson22.homework.extensions.returnGenericNull
import org.st412m.kotlincourse.lesson22.homework.extensions.returnMapGenericNull
import org.st412m.kotlincourse.lesson22.homework.extensions.returnNothing
import org.st412m.kotlincourse.lesson22.homework.extensions.returnPair
import org.st412m.kotlincourse.lesson22.homework.extensions.returnSting

fun main() {
    println("----Задача 1а ArrayReturnPair-----")

    val numbers = arrayOf<Number>(1, 2, 3, 4)
    val emptyArray = arrayOf<Number>()

    println(numbers.returnPair())
    println(emptyArray.returnPair())

    println()
    println("----Задача 1b ReturnNothing-----")

    val char = 'A'
    char.returnNothing(1, 2, true)

    val char1: Char? = null
    char1.returnNothing(1, 2, false)

    println()
    println("----Задача 1c ReturnGenericNull-----")

    val list = mutableListOf("a", "b", "c", "d")

    println(list.returnGenericNull("x", 1))
    println(list.returnGenericNull(null, 2))
    println(list.returnGenericNull("y", 10))

    println()
    println("----Задача 1d ReturnMapGenericNull-----")

    val map: Map<Number, List<Int>> = mapOf(
        0.1 to listOf(10, 20, 30),
        2f to listOf(40, 50),
        3 to listOf()
    )
    println(map.returnMapGenericNull(1))

    println()
    println("----Задача 1e ReturnString-----")

    val value = 123456789L
    println(value.returnSting())

    val nullValue: Long? = null
    println(nullValue.returnSting())
}