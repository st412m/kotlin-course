package org.st412m.kotlincourse.lesson19.homework.calculator

class CalculatorClass {

    private val operations = listOf(
        Addition(),
        Subtraction(),
        Multiplication(),
        Division(),
        Modulus()
    )

    fun calculate(expression: String): String {
        val operatorType = listOf("+", "-", "*", "/", "%").firstOrNull { expression.contains(it) }
            ?: return "Операция не найдена в выражении"
        val operands = splitExpression(expression, operatorType)
            ?: return "Ошибка в разбиении выражения на операнды"
        val operation = operations.firstOrNull { it.symbol == operatorType }
            ?: return "Операция невозможна для данных операндов"
        return operation.execute(operands)
    }

    private fun splitExpression(expression: String, operatorType: String): Pair<Any, Any>? {
        val operatorIndex = expression.indexOf(operatorType)
        if (operatorIndex == -1) return null

        val firstOperand = expression.substring(0, operatorIndex).trim()
        val secondOperand = expression.substring(operatorIndex + operatorType.length).trim()

        return Pair(OperandUtils.parseOperand(firstOperand), OperandUtils.parseOperand(secondOperand))
    }
}

private class Addition : OperationClass("+") {
    override fun execute(operands: Pair<Any, Any>): String {
        return if (isApplicable(operands)) {
            val doubleOperands = OperandUtils.makeDouble(operands)
            when {
                doubleOperands != null -> (doubleOperands.first + doubleOperands.second).toString()
                operands.first is String && operands.second is String -> {
                    val firstStr = operands.first as String
                    val secondStr = operands.second as String
                    firstStr + secondStr
                }
                else -> "Операция невозможна"
            }
        } else {
            "Операция невозможна"
        }
    }

    override fun isApplicable(operands: Pair<Any, Any>): Boolean {
        return OperandUtils.bothDoubles(operands) ||
                (operands.first is String && operands.second is String)
    }
}

private class Subtraction : OperationClass("-") {
    override fun execute(operands: Pair<Any, Any>): String {
        val doubleOperands = OperandUtils.makeDouble(operands)
        return if (doubleOperands != null) {
            (doubleOperands.first - doubleOperands.second).toString()
        } else {
            "Операция невозможна"
        }
    }

    override fun isApplicable(operands: Pair<Any, Any>): Boolean {
        return OperandUtils.bothDoubles(operands)
    }
}

private class Multiplication : OperationClass("*") {
    override fun execute(operands: Pair<Any, Any>): String {
        return if (isApplicable(operands)) {
            val doubleOperands = OperandUtils.makeDouble(operands)
            when {
                doubleOperands != null -> (doubleOperands.first * doubleOperands.second).toString()
                operands.first is String && operands.second is Double -> {
                    val str = operands.first as String
                    val count = (operands.second as Double).toInt()
                    if (count.toDouble() == operands.second) {
                        str.repeat(count)
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
        return OperandUtils.bothDoubles(operands) ||
                (operands.first is String && operands.second is Double)
    }
}

private class Division : OperationClass("/") {
    override fun execute(operands: Pair<Any, Any>): String {
        val doubleOperands = OperandUtils.makeDouble(operands)
        return if (doubleOperands != null) {
            if (doubleOperands.second == 0.0) {
                "Деление на ноль невозможно"
            } else {
                (doubleOperands.first / doubleOperands.second).toString()
            }
        } else {
            "Операция невозможна"
        }
    }

    override fun isApplicable(operands: Pair<Any, Any>): Boolean {
        return OperandUtils.bothDoubles(operands)
    }
}

private class Modulus : OperationClass("%") {
    override fun execute(operands: Pair<Any, Any>): String {
        val doubleOperands = OperandUtils.makeDouble(operands)
        return if (doubleOperands != null) {
            if (doubleOperands.second == 0.0) {
                "Деление на ноль невозможно"
            } else {
                (doubleOperands.first % doubleOperands.second).toString()
            }
        } else {
            "Операция невозможна"
        }
    }

    override fun isApplicable(operands: Pair<Any, Any>): Boolean {
        return OperandUtils.bothDoubles(operands)
    }
}


private object OperandUtils {
    fun makeDouble(operands: Pair<Any, Any>): Pair<Double, Double>? {
        return if (operands.first is Double && operands.second is Double) {
            operands.first as Double to operands.second as Double
        } else null
    }

    fun bothDoubles(operands: Pair<Any, Any>): Boolean {
        return operands.first is Double && operands.second is Double
    }

    fun parseOperand(operand: String): Any {
        return when {
            operand.toDoubleOrNull() != null -> operand.toDouble()
            else -> operand
        }
    }

}

