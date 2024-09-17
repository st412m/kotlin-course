package org.st412m.kotlincourse.lesson5

fun main() {
    val sum = 10 + 5
    val sum1 = "10" + "5"
    val diff = 10 - 5
    val product = 10 * 5
    val quotient = 10 / 5
    val remainder = 10 % 6 //остаток от деления

    val isEqual = (5 == 5) //сравнение выдает булево
    val isNotEqual = (5 != 3) //сравнение выдает булево
    val isLeaser = (5 < 3) //сравнение выдает булево
    val isGreater = (5 > 3) //сравнение выдает булево
    val isLeaserOrEqual = (5 >= 3) //сравнение выдает булево
    val isGreaterOrEqual = (5 <= 3) //сравнение выдает булево
    val andResult = false && false // логическое И - все операнды должны быть true, чтобы вернуть true
    val orResult = true || false  // логическое ИЛИ - один из операндов должен быть true, чтобы вернуть true
    val notResult = !(5 > 3) //сравнение выдает булево, грубо говоря "переворачивает" true на false или наоборот

    var number = 5
    number += 3 // number = number + 3  тоже самое number -= 3 (number = number - 3) тоже с умножением и деления
    number ++   //увеличит на 1
    number --  //уменьшит на 1

    val example = ((8 + 1) >= 9) || (6 - 2 != 4) && (2 * 3 == 6)


    println(sum)
    println(sum1)
    println(diff)
    println(product)
    println(quotient)
    println(remainder)
    println("-------------------")
    println(isEqual)
    println(isNotEqual)
    println(isLeaser)
    println(isGreater)
    println(isLeaserOrEqual)
    println(isGreaterOrEqual)
    println(andResult)
    println(orResult)
    println(notResult)
    println("-------------------")
    println(number)
    println("-------------------")
    println(number++)
    println(number)
    println(++number)
    println(number)
    println("-------------------")
    println(example)

}
