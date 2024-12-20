package org.st412m.kotlincourse.lesson26.homework

import kotlin.math.absoluteValue

fun naheraAGlavnoeZachem(
    arg1: Int,
    arg2: (((((Int) -> String) -> Boolean) -> Double) -> List<Double>) -> (() -> String) -> Unit,
): (() -> String) -> Unit {
    var condition: (String) -> Boolean = { it.length > 1 }
    val levelOne = { arg1.toString() }
    val levelTwo = { if (condition(levelOne()) || arg1 > 0) 1.1 else 0.0 }
    val levelThree = { (1..arg1.absoluteValue).map { levelTwo() } }

    return { stringFunc ->
        arg2 { levelTwoFunc ->
            levelThree()
        }
        println(
            "Переданная строка: ${stringFunc()}\n" +
                    "странный список: ${levelThree()}\n" +
                    "зачем-то переданный аргумент: $arg1"
        )
    }
}

fun main() {
    val shizoText = "Не выходи из комнаты, не совершай ошибку"
    val result = naheraAGlavnoeZachem(-2) { func ->
        { stringFunc ->
            { func { it.toString().toDouble() } }
        }
    }
    result { shizoText }
}

