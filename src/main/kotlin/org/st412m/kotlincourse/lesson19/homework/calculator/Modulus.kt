package org.st412m.kotlincourse.lesson19.homework.calculator

private class Modulus : OperationClass() {
    override fun execute(operands: Pair<Any, Any>): String {
        return if (isApplicable(operands)) {
            (operands.first as Double % operands.second as Double).toString()
        } else {
            "Операция невозможна"
        }
    }

    override fun isApplicable(operands: Pair<Any, Any>): Boolean {
        return (operands.first is Double && operands.second is Double)
    }
}