package org.st412m.kotlincourse.lesson17.homework

import kotlin.math.sqrt

/*
Потренируйся в создании иерархии классов с расширением базовой сущности.
Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.
Для произвольных классов также добавь особенные свойства. Детально описывать не нужно, упражнение на то, чтобы усвоить
иерархию наследования.

Геометрические Фигуры
Базовый класс: Геометрическая Фигура
Производные классы: Многоугольник, Круг
Дополнительное разветвление для многоугольника: Треугольник, Четырехугольник
 */

open class GeometricShapes(){
    open fun figurePerimeter(): Double{
        return TODO("Provide the return value")
    }
    open fun figureArea(): Double {
        return TODO("Provide the return value")
    }
}

open class Polygon(val sides: List<Double>): GeometricShapes() {
    override fun figurePerimeter(): Double = sides.sum()
}

class Triangle(a: Double, b: Double, c: Double): Polygon(listOf(a, b, c)){
    override fun figureArea(): Double {
        val p = figureArea() / 2
        val (a, b, c) = sides
        return sqrt(p * (p - a) * (p - b) * (p - c))
    }
}

class Tetragon(a: Double, b: Double, c: Double, d: Double): Polygon(listOf(a, b, c, d)) {

    override fun figurePerimeter(): Double {
        return TODO("Provide the return value")
    }
}

class Сircle(private val radius: Double) : GeometricShapes() {
    val pi: Double = 3.14159
    override fun figureArea(): Double {
        return pi * radius * radius
    }

    override fun figurePerimeter(): Double {
        return 2 * pi * radius
    }
}