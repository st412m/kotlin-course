package org.st412m.kotlincourse.lesson19.homework.calculator

abstract class OperationClass {

    abstract fun execute(operand1: Any, operand2: Any): Any

    abstract fun isApplicable(operand1: Any, operand2: Any): Boolean

    abstract fun splitExpression(expression: String): Pair<Any, Any>
}