package org.st412m.kotlincourse.lesson23.homework
/*
Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести
соответствующее сообщение:
Для строки: "Это строка: [значение]".
Для целого числа: "Это целое число: [значение]".
Для списка: "Это список, количество элементов: [количество]".
Для карты: "Это карта, количество пар: [количество]".
Для остальных типов: "Неизвестный тип данных".
Используйте оператор is для проверки типов.
 */

fun analyzeDataType(arg: Any?) {
    when(arg) {
        is String -> println("Это строка: $arg")
        is Int -> println("Это целое число: $arg")
        is List<*> -> println("Это список, количество элементов: ${arg.size}")
        is Map<*, *> -> println("Это карта, количество пар: ${arg.size}")
        else -> println("Неизвестный тип данных")
    }
}
/*
Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно
безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1.
Используйте as? для безопасного приведения типа.
 */

fun safeCastToList(arg: Any): Int {
    return (arg as? List<*>)?.size ?: -1
}

/*
Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент
можно привести к типу String. В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.
 */

fun getStringLengthOrZero(arg: Any?): Int {
    return (arg as? String)?.length ?: 0
}

/*
Создайте функцию, которая принимает параметр типа Any.
Функция гарантированно ожидает число (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть
квадрат этого числа. Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать
в число через функцию toDouble() и возвести в квадрат.
 */

fun squareNumber(arg: Any?): Double {
    return when (arg) {
        is Number -> arg.toDouble() * arg.toDouble()
        is String -> {
            val transformedArg = arg.toDouble()
            transformedArg * transformedArg
        }
        else -> 0.0
    }
}

/*
Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных
(Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
 */

fun sumIntOrDoubleValues(arg: List<Any?>): Double {
    var sum = 0.0
    for (i in arg) {
        if (i is Int || i is Double) {
            sum += i.toDouble()
        }
    }
    return sum
}

/*
Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести
предупреждение об этом. Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение
программы.
 */

fun tryCastToListAndPrint(arg: Any?) {
    val list = arg as? List<*>

    if (list != null) {
        for (item in list) {
            if (item is String) {
                println(item)
            } else {
                println("$item не является строкой.")
            }
        }
    } else {
        println("$arg не является списком.")
    }
}


fun main(){
    println("-----Задача 1------")
    val arg1 = "Дратути"
    val arg2 = 1
    val arg3 = listOf(1, 2, 3)
    val arg4 = mapOf("один" to 1, "два" to 2, "три" to 3, "четыре" to 4)
    val arg5 = null
    analyzeDataType(arg1)
    analyzeDataType(arg2)
    analyzeDataType(arg3)
    analyzeDataType(arg4)
    analyzeDataType(arg5)

    println()
    println("-----Задача 2------")
    val arg6 = listOf(1, 2, 3)
    val arg7 = "cnhjrf"
    println(safeCastToList(arg6))
    println(safeCastToList(arg7))

    println()
    println("-----Задача 3------")
    val arg8 = "строка"
    val arg9 = 1
    val arg10 = null
    println(getStringLengthOrZero(arg8))
    println(getStringLengthOrZero(arg9))
    println(getStringLengthOrZero(arg10))

    println()
    println("-----Задача 4------")
    val arg11 = 4
    val arg12 = 4.2
    val arg13 = "4.2"
    println(squareNumber(arg11))
    println(squareNumber(arg12))
    println(squareNumber(arg13))

    println()
    println("-----Задача 5------")
    println(sumIntOrDoubleValues(listOf<Any?>(1, "один", 1f, 1L, 2, 3, null, true)))

    println()
    println("-----Задача 6------")
    val arg14 = listOf("йцукенг", 123, "фыва", 45.6, true, "пролд")
    val arg15 = "Так себе список"

    tryCastToListAndPrint(arg14)
    tryCastToListAndPrint(arg15)

}