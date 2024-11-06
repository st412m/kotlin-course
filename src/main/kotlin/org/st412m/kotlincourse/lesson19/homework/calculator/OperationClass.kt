package org.st412m.kotlincourse.lesson19.homework.calculator

abstract class OperationClass {

    abstract fun execute(operands: Pair<Any, Any>): String

    abstract fun isApplicable(operands: Pair<Any, Any>): Boolean

    protected fun splitExpression(expression: String): Pair<Any, Any> {
        val operands = expression.split(expression)
        return Pair(OperandParser.parseOperand(operands[0]), OperandParser.parseOperand(operands[1]))
    }
}