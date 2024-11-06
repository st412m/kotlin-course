package org.st412m.kotlincourse.lesson19.homework.calculator

private class Multiplication : OperationClass() {
    override fun execute(operands: Pair<Any, Any>): String {
        return if (isApplicable(operands)) {
            when {
                operands.first is Double && operands.second is Double -> {
                    (operands.first as Double * operands.second as Double).toString()
                }
                operands.first is String && operands.second is Double -> {
                    val repeatCount = (operands.second as Double).toInt()
                    if (repeatCount.toDouble() == operands.second) {
                        (operands.first as String).repeat(repeatCount)
                    } else {
                        "Число для умножения на строку должно быть целым"
                    }
                }
                else -> "Операция невозможна"
            }
        } else {
            "Операция невозможна"
        }
    }

    override fun isApplicable(operands: Pair<Any, Any>): Boolean {
        return (operands.first is Double && operands.second is Double) || (operands.first is String && operands.second is
                Double)
    }

}