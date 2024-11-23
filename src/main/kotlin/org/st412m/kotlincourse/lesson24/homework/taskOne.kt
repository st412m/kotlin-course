package org.st412m.kotlincourse.lesson24.homework
/*
Задание 1. Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
NullPointerException
ArrayIndexOutOfBoundsException
ClassCastException
NumberFormatException
IllegalArgumentException
IllegalStateException
OutOfMemoryError
StackOverflowError
 */

fun main() {
    println("-------NullPointerException-------")
    val nullableVar = null
       nullableVar as String

    println()
    println("-------ArrayIndexOutOfBoundsException-------")
    val arrayIndexOut = listOf(1, 2, 3, 4, 5)
    arrayIndexOut[6]

    println()
    println("-------ClassCastException-------")
    val classCastExcept = "строка"
    classCastExcept as Int

    println()
    println("-------NumberFormatException-------")
    val numFormat = listOf(1, 2, "1,2")
    for (i in numFormat.indices) {
        val i = numFormat[i]
        if (i is String) {
            println(i.toInt())
        } else if (i is Int) {
            println(10 + i)
        }
    }

    println()
    println("-------IllegalArgumentException-------")
    val list = listOf(1, 2, 3, 4, 5)
    val newList = list.subList(4, 2) // тут в общем метод создает еще один список из нашего списка, аналогично методу
// сабстринг(но он выкидывает только StringIndexOutOfBoundsException).

    println()
    println("-------IllegalStateException-------")
    val illegalStateExc = 0
    check(illegalStateExc == 1)

    println()
    println("-------OutOfMemoryError-------")
    val outOfMemList = mutableListOf("растудыть твою в туды")
    while (true)
        outOfMemList.add("и еще немного растудыть твою в туды")

    println()
    println("-------StackOverflowError-------")
    functionA()

}
fun functionA() {
    functionB()
}

fun functionB() {
    functionA()
}


