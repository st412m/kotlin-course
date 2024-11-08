package org.st412m.kotlincourse.lesson19.homework.calculator

fun main() {
    val calculator = CalculatorClass()
    println(calculator.calculate("3 + 4"))
    println(calculator.calculate("10.5 * 2"))
    println(calculator.calculate("вася + петя"))
    println(calculator.calculate("Hello * 3"))
    println(calculator.calculate("Hello * 3.4"))
    println(calculator.calculate("11-1"))
    println(calculator.calculate("5 % 2"))
    println(calculator.calculate("5 % Петя"))
    println(calculator.calculate("Петя % 5"))
    println(calculator.calculate("3 * Петя"))
    println(calculator.calculate("10 / Петя"))
    println(calculator.calculate("10 / 3"))
    println(calculator.calculate("10 / 0"))
    println(calculator.calculate("1 + Петя"))
    println(calculator.calculate("10 - Петя"))
    println(calculator.calculate("10 : 1"))
    println(calculator.calculate("++2"))
    println(calculator.calculate("Петя - Вася"))
}