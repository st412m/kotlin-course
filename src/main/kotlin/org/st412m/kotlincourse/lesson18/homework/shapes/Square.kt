package org.st412m.kotlincourse.lesson18.homework.shapes

class Square(val side: Double) : Shape() {
    override fun figureArea(): Double {
        return side * side
    }
}