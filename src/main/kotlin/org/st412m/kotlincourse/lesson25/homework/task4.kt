package org.st412m.kotlincourse.lesson25.homework
/*
Задание 4. Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа.
По аналогии с предыдущим заданием выполни трансформации и проверки.
Подсказка: для парсинга строки “3” в число 3 можно использовать “3”.digitToInt()
 */

fun main() {

    val bigNum = 12345678987654321L

    val bigNumToSum1 = fun(bigNum: Long): Int {
        return (bigNum.toString().map { it.digitToInt() }).sum()
    }

    val bigNumToSum2: (bigNum: Long) -> Int = { it ->
        (bigNum.toString().map { it.digitToInt() }).sum()
    }

    val bigNumToSum3 = { bigNum: Long ->
        (bigNum.toString().map { it.digitToInt() }).sum()
    }

    println(bigNumToSum(bigNum))
    println(bigNumToSum1(bigNum))
    println(bigNumToSum2(bigNum))
    println(bigNumToSum3(bigNum))
}

fun bigNumToSum(bigNum: Long): Int {
    return (bigNum.toString().map { it.digitToInt() }).sum()
}