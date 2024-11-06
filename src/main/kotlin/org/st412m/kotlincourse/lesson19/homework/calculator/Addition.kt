package org.st412m.kotlincourse.lesson19.homework.calculator

private class Addition : OperationClass() {
    override fun execute(operands: Pair<Any, Any>): String {
        return if (isApplicable(operands)) {
            if (operands.first is Double && operands.second is Double) {
                (operands.first as Double + operands.second as Double).toString()
            }
            else if (operands.first is String && operands.second is String) {
                operands.first as String + operands.second as String
            }
            else {
                "Операция невозможна"
            }
        } else {
            "Операция невозможна"
        }
    }

    override fun isApplicable(operands: Pair<Any, Any>): Boolean {
        return (operands.first is Double && operands.second is Double) || (operands.first is String && operands.second is
                String)
    }
}