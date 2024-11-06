package org.st412m.kotlincourse.lesson19.homework.calculator

class Addition : OperationClass() {
    override fun execute(operand1: Any, operand2: Any): String {
        return TODO("Provide the return value")
    }

    override fun isApplicable(operand1: Any, operand2: Any): Boolean {
        return (operand1 is Double && operand2 is Double) || (operand1 is String && operand2 is String)
    }

}