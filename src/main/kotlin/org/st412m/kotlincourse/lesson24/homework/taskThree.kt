package org.st412m.kotlincourse.lesson24.homework
/*
Задание 3. Оберни все вызовы из предыдущего задания в блок try-catch с одним блоком catch для любого типа исключений.
Внутри блока catch, используя when, напиши для каждого исключения вывод в консоль специфического сообщения, подходящего
под каждый из типов.
 */

fun main() {
    try {
        val nullableVar = null
        nullableVar as String

        val arrayIndexOut = listOf(1, 2, 3, 4, 5)
        arrayIndexOut[6]

        val classCastExcept = "строка"
        classCastExcept as Int

        val numFormat = listOf(1, 2, "1,2")
        for (i in numFormat.indices) {
            val i = numFormat[i]
            if (i is String) {
                println(i.toInt())
            } else if (i is Int) {
                println(10 + i)
            }
        }

        val list = listOf(1, 2, 3, 4, 5)
        val newList = list.subList(4, 2)

        val illegalStateExc = 0
        check(illegalStateExc == 1)

        val outOfMemList = mutableListOf("растудыть твою в туды")
        while (true)
            outOfMemList.add("и еще немного растудыть твою в туды")

        functionA()
    } catch (e: Throwable) {
        when (e) {
            is NullPointerException -> println("Это NullPointerException")
            is ArrayIndexOutOfBoundsException -> println("Это ArrayIndexOutOfBoundsException")
            is ClassCastException -> println("Это ClassCastException")
            is NumberFormatException -> println("Это NumberFormatException")
            is IllegalArgumentException -> println("Это IllegalArgumentException")
            is IllegalStateException -> println("Это IllegalStateException")
            is OutOfMemoryError -> println("Это OutOfMemoryError")
            is StackOverflowError -> println("Это StackOverflowError")
            else -> println("Непонятное исключение")
        }
    }
}