package org.st412m.kotlincourse.lesson26.homework

import java.util.logging.Filter

/*
Напишите функцию filterStrings, которая принимает список строк и функцию-фильтр, оставляющую только строки,
удовлетворяющие условию (то-есть принимающая строку и возвращающая булево значение). Функция должна вернуть результат
фильтрации исходного списка строк.
 */

fun filterStrings(
    list: List<String>,
    filterStr: (String) -> Boolean
): List<String>{
   return list.filter(filterStr)
}


/*
Создайте функцию applyToNumbers, которая принимает список чисел и функцию, преобразующую каждое число в другое число
(те-есть принимающая число и возвращающая число). Функция должна вернуть результат преобразования исходного списка чисел.
 */

fun applyToNumbers(
    list: List<Number>,
    numTransformation: (Number) -> Number
): List<Number> {
    return list.map{numTransformation(it)}
}


/*
Реализуйте функцию sumByCondition, которая принимает список чисел и функцию, определяющую условие для включения числа
в сумму. Функция должна вернуть сумму чисел, прошедших проверку.
 */




/*
Напишите функцию combineAndTransform, которая принимает две коллекции одного типа и функцию для их объединения и
преобразования в одну коллекцию другого типа. Функция должна вернуть результат преобразования (коллекцию второго типа)
 */

fun main() {
    println("\n----- Задача 1 -----")
    val stringsList = listOf("яблоко", "банан", "дом", "вертолет", "дача", "селёдка")
    println(filterStrings(stringsList){it.length > 4})
    println(filterStrings(stringsList){"а" in it})

    println("\n----- Задача 2 -----")
    val numList1 = listOf(1, 2, -1, 5, -10)
    val numList2 = listOf(1.0, 2.0, -1.0, 5.0, -10.0)
    println(applyToNumbers(numList1){it.toDouble()})
    println(applyToNumbers(numList2){it.toInt() * 2})
}