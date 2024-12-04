package org.st412m.kotlincourse.lesson26.homework

/*
Напишите функцию filterStrings, которая принимает список строк и функцию-фильтр, оставляющую только строки,
удовлетворяющие условию (то-есть принимающая строку и возвращающая булево значение). Функция должна вернуть результат
фильтрации исходного списка строк.
 */

fun filterStrings(
    list: List<String>,
    filterStr: (String) -> Boolean,
): List<String> {
    return list.filter(filterStr)
}


/*
Создайте функцию applyToNumbers, которая принимает список чисел и функцию, преобразующую каждое число в другое число
(те-есть принимающая число и возвращающая число). Функция должна вернуть результат преобразования исходного списка чисел.
 */

fun applyToNumbers(
    list: List<Number>,
    numTransformation: (Number) -> Number,
): List<Number> {
    return list.map { numTransformation(it) }
}


/*
Реализуйте функцию sumByCondition, которая принимает список чисел и функцию, определяющую условие для включения числа
в сумму. Функция должна вернуть сумму чисел, прошедших проверку.
 */

fun sumByCondition(
    numList: List<Number>,
    conditionDefinition: (Number) -> Boolean,
): Double {
    return numList.filter(conditionDefinition).sumOf { it.toDouble() }
}


/*
Напишите функцию combineAndTransform, которая принимает две коллекции одного типа и функцию для их объединения и
преобразования в одну коллекцию другого типа. Функция должна вернуть результат преобразования (коллекцию второго типа)
 */

fun combineAndTransform(
    collectionOne: List<String>,
    collectionTwo: List<Int>,
    convertToMap: (List<String>, List<Int>) -> Map<String, Int>,

    ): Map<String, Int> {
    return convertToMap(collectionOne, collectionTwo)
}


fun main() {
    println("\n----- Задача 1 -----")
    val stringsList = listOf("яблоко", "банан", "дом", "вертолет", "дача", "селёдка")
    println(filterStrings(stringsList) { it.length > 4 })
    println(filterStrings(stringsList) { "а" in it })

    println("\n----- Задача 2 -----")
    val numList1 = listOf(1, 2, -1, 5, -10)
    val numList2 = listOf(1.0, 2.0, -1.0, 5.0, -10.0)
    println(applyToNumbers(numList1) { it.toDouble() })
    println(applyToNumbers(numList2) { it.toInt() * 2 })

    println("\n----- Задача 3 -----")
    val numList3 = listOf(1, -2, 3, -4, 5, -6)
    val numList4 = listOf(1.0, -2.0, 3.01, -4.06, 5.0, -6.0)
    println(sumByCondition(numList3) { it.toDouble() > 0 })
    println(sumByCondition(numList4) { it.toString().length < 4 })

    println("\n----- Задача 4 -----")
    val collectionOne = listOf("один", "два", "три", "четыре")
    val collectionTwo = listOf(1, 2, 3, 4)
    val collectionThree = listOf("один", "два", "три", "четыре", "пять")
    val collectionFour = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


    val result = combineAndTransform(collectionOne, collectionTwo) { list1, list2 ->
        val map = mutableMapOf<String, Int>()
        val size = minOf(list1.size, list2.size)
        for (i in 0 until size) {
            map[list1[i]] = list2[i]
        }
        map
    }

    println(result)

    val anotherResult = combineAndTransform(collectionThree, collectionFour) { list1, list2 ->
        val map = mutableMapOf<String, Int>()
        val keyListSize = list1.size

        for (i in list2.indices) {
            val key = if (i < keyListSize) {
                list1[i]
            } else {
                list1[i % keyListSize] + "-" + list2[i]
            }
            map[key] = list2[i]
        }
        map
    }
    println(anotherResult)
}




