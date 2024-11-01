package org.st412m.kotlincourse.lesson18.homework.shapes

import kotlin.math.sqrt

class Triangle(val sideA: Double, val sideB: Double, val sideC: Double) : Shape() {
    val p = (sideA + sideB + sideC) / 2
    override fun figureArea(): Double {
        return sqrt(p * (p - sideA) * (p - sideB)* (p - sideC))
    }
}