package org.st412m.kotlincourse.lesson12


/*
Сделай рефакторинг функции, которую разбирали на уроке и устрани баг, из-за которого таблица разъезжается
при разных размерностях аргументов
 */

fun main(){
    printMap(10, -15)
}

private fun checkSize(size: Int, nameArg: String) {
    if (size == 0) throw IllegalArgumentException("$nameArg не должно быть равным нулю")
}

private fun createRange(size: Int): IntProgression {
    return if (size > 0) {
        0..size
    } else {
        0 downTo size
    }
}
private fun printFormatted(value: Any, formatterSize: Int) {
    print("%${formatterSize}s".format(value))
}

fun printMap(xSize: Int, ySize: Int) {
    checkSize(xSize, "xSize")
    checkSize(ySize, "ySize")
//    if (xSize == 0) throw IllegalArgumentException("xSize не должно быть равным нулю")
//    if (ySize == 0) throw IllegalArgumentException("ySize не должно быть равным нулю")
    val formatterSize = " $xSize".length
    val xRange = createRange(xSize)
//        if (xSize > 0) {
//        0..xSize
//    } else {
//        0 downTo xSize
//    }
    val yRange = createRange(ySize)
//        if (ySize > 0) {
//        0..ySize
//    } else {
//        0 downTo ySize
//    }

    print(" ".repeat(formatterSize))
    for (i in xRange) {
//        print("%${formatterSize}s".format(i))
        printFormatted(i, formatterSize)
    }
    println()
    for (i in yRange) {
//        print("%${formatterSize}s".format(i))
        printFormatted(i, formatterSize)
        for (j in xRange) {  // косяк!!! распечатывались значения по диапазону y, а должны по x
            val m = i * j
            val result = when {
                m % 2 == 0 -> if (m % 3 == 0) "." else "*"
                m % 5 == 0 -> if (i < 0) "-" else "+"
                else -> "?"
            }
//            print("%${formatterSize}s".format(result))
            printFormatted(result, formatterSize)
        }
        println()
    }
}