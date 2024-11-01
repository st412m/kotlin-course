package org.st412m.kotlincourse.lesson18.homework.shapes

class Circle(val radius: Double) : Shape() {
    override fun figureArea(): Double {
        return 3.14 * radius * radius
    }
}