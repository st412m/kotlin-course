package org.st412m.kotlincourse.lesson19.homework.calculator

abstract class OperationClass {

    abstract fun execute(operand1: Any, operand2: Any): String

    abstract fun isApplicable(operand1: Any, operand2: Any): Boolean

    protected fun splitExpression(expression: String): Pair<Any, Any> {
        val operands = expression.split(expression)
        return Pair(OperandParser.parseOperand(operands[0]), OperandParser.parseOperand(operands[1]))
    }
}