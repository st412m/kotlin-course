package org.st412m.kotlincourse.lesson22.homework

import org.st412m.kotlincourse.lesson22.homework.extensions.decrypt
import org.st412m.kotlincourse.lesson22.homework.extensions.encrypt
import org.st412m.kotlincourse.lesson22.homework.extensions.pidmarkoz
import org.st412m.kotlincourse.lesson22.homework.extensions.returnGenericNull
import org.st412m.kotlincourse.lesson22.homework.extensions.returnMapGenericNull
import org.st412m.kotlincourse.lesson22.homework.extensions.returnNothing
import org.st412m.kotlincourse.lesson22.homework.extensions.returnPair
import org.st412m.kotlincourse.lesson22.homework.extensions.returnSting
import org.st412m.kotlincourse.lesson22.homework.extensions.revert
import org.st412m.kotlincourse.lesson22.homework.extensions.within

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

    println()
    println("----Задача 3 Revert-----")
    val pair1 = Pair(1, "one")
    println(pair1.revert())
    val pair2 = Pair(1.0, null)
    println(pair2.revert())
    val pair3 = Pair(null, "один")
    println(pair3.revert())

    println()
    println("----Задача 4 Within-----")
    val num1: Int = 100
    val num2: Double = 101.5
    val deviation: Float = 1.5f

    println(num1.within(num2, deviation))
    println(num1.within(105, deviation))
    println(50.0.within(50.5, 0.6))
    println(10L.within(15L, 4))

    println()
    println("----Задача 5 Encrypt/Decrypt-----")
    val text = "Hello Kitty"
    val shift = 3
    val encryptedText = text.encrypt(shift)
    println(encryptedText)
    val decryptedText = encryptedText.decrypt(shift)
    println(decryptedText)

    println()
    println("----ПИДМАРКОЗ-----")
    val userList= listOf("Павел", "Иван", "Дмитрий", "Олег", "Роман", "Адольф", "Семен")
    val word = "Гитлер!"
    word.pidmarkoz(userList)
}