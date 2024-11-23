package org.st412m.kotlincourse.lesson24.homework
/*
Задание 2. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок
 */

fun main() {
    println("-------NullPointerException-------")
    try {
        val nullableVar = null
        nullableVar as String
    } catch (e: NullPointerException) {
        println("Это вызывает NullPointerException ")
    }

    println()
    println("-------ArrayIndexOutOfBoundsException-------")
    try {
        val arrayIndexOut = listOf(1, 2, 3, 4, 5)
        arrayIndexOut[6]
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Это вызывает ArrayIndexOutOfBoundsException ")
    }

    println()
    println("-------ClassCastException-------")
    try {
        val classCastExcept = "строка"
        classCastExcept as Int
    } catch (e: ClassCastException) {
        println("Это вызывает ClassCastException")
    }

    println()
    println("-------NumberFormatException-------")
    try {
        val numFormat = listOf(1, 2, "1,2")
        for (i in numFormat.indices) {
            val i = numFormat[i]
            if (i is String) {
                println(i.toInt())
            } else if (i is Int) {
                println(10 + i)
            }
        }
    } catch (e: NumberFormatException) {
        println("Это вызывает NumberFormatException")
    }

    println()
    println("-------IllegalArgumentException-------")
    try {
        val list = listOf(1, 2, 3, 4, 5)
        val newList = list.subList(4, 2)
    } catch (e: IllegalArgumentException) {
        println("Это вызывает IllegalArgumentException")
    }

    println()
    println("-------IllegalStateException-------")
    try {
        val illegalStateExc = 0
        check(illegalStateExc == 1)
    } catch (e: IllegalStateException) {
        println("Это вызывает IllegalStateException ")
    }

    println()
    println("-------OutOfMemoryError-------")
    try {
        val outOfMemList = mutableListOf("растудыть твою в туды")
        while (true)
            outOfMemList.add("и еще немного растудыть твою в туды")
    } catch (e: OutOfMemoryError) {
        println("Это вызывает OutOfMemoryError")
    }

    println()
    println("-------StackOverflowError-------")
    try {
        functionA()
    } catch (e: StackOverflowError) {
        println("Это вызывает StackOverflowError")
    }
}

