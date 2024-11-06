package org.st412m.kotlincourse.lesson19.homework.calculator

object OperandParser {
    fun parseOperand(operand: String): Any {
        return when {
            operand.toDoubleOrNull() != null -> operand.toDouble()
            else -> operand
        }
    }
}