package org.st412m.kotlincourse.lesson18.homework.printer

import org.st412m.kotlincourse.lesson18.printColored

abstract class Printer () {
    abstract fun print(str: String)

    protected fun printText(str: String, color: String, backgroundColor: String) {
        val words = str.split(" ")
        words.forEach { word -> printColored(word, color, backgroundColor) }
    }
}
