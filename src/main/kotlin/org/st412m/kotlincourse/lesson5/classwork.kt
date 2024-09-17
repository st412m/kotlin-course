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
    number++   //увеличит на 1
    number--  //уменьшит на 1

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
    println("-------------------")
    val a = (3 + 2 < 6) && (4 * 2 == 8) // true
    val b = (10 - 5 >= 5) || (2 * 3 != 6) //true
    val c = (8 / 2 == 4) && (7 % 3 != 1) // false
    val d = (9 - 3 >= 6) && (8 / 2 != 4) // false
    val e = ((3 + 4) < 8) && (12 / 3 == 4) || (5 % 2 != 1) //true
    val f = ((10 - 5) >= 5) || (6 * 2 != 12) && !(9 / 3 > 2) // true
    val g = ((2 * 5) == 10) && !(7 - 3 < 5) || (8 / 2 == 4) // true
    val h = ((9 + 2) < 12) && (15 % 4 != 3) || !(4 * 2 == 8) // false

//    ((var a = 4; a-- == 4) || (5 * 2 != 10)) && (3 + 1 == 4) //a-- == 4 сначала сравниваем, а уже потом декремент
//    // (постдекремент)
//    // т.е
//// var a = 4; a-- == 4 - будет true
//
//    (var b = 3; b++ > 3) && (6 / 2 == 3) || (7 - 2 != 5) // b++ - постинкремент  общее - false
//
//    (var c = 1; ++c < 3) || ((4 % 2 == 0) && (5 + 0 == 5)) // ++с - инкремент, сначала прибавляем 1, а потом сравниваем
//
//    ((var d = 5; d-- == 5) && (8 / 4 == 2)) || (2 * 3 != 6) // d-- -постдекремент, сначала сравниваем, потом вычитаем 1
//
//    (var e = 2; e++ < 3) && ((7 + 1 == 8) || (4 % 2 != 0)) // true

    //Оператор Элвиса
    var name: String? = null

    val result = name ?: "Unknown"
// -----------------------------------------


    printVolume(userVolume = null)
    printPrice(price = 123.2, discount = 12)
    printPrice(price = 123.2, discount = null)

}
fun printVolume(userVolume: Int?) {
    val defaultVolume = 30
    println(userVolume ?: defaultVolume)
}

fun printPrice(price: Double, discount: Int?){
    var coefficient = (100 - (discount ?: 0))/100.0
    println(price * coefficient)
}
