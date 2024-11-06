package org.st412m.kotlincourse.lesson19.homework.calculator

abstract class OperationClass(
    val symbol: String
) {
    abstract fun execute(operands: Pair<Any, Any>): String

    abstract fun isApplicable(operands: Pair<Any, Any>): Boolean

}