package org.st412m.kotlincourse.lesson18.homework.printer

import org.st412m.kotlincourse.lesson18.homework.Background
import org.st412m.kotlincourse.lesson18.homework.Colors
import org.st412m.kotlincourse.lesson18.homework.printColored

class LaserPrinter() : Printer() {
    override fun print(str: String) {
        printText(str, Colors.BLACK, Background.WHITE)
    }
}