package org.st412m.kotlincourse.lesson30

object NumsObject {

    const val ONE = "ONE"
    const val TWO = "TWO"
    const val THREE = "THREE"
}

enum class Nums {  //перечисление констант, неизменяемое в рантайме. Перечисления ПРИНЯТО ПИСАТЬ ЗАГЛАВНЫМИ БУКВАМИ
    ONE,
    TWO,
    THREE
}

enum class DayOfWeek(val isWeekend: Boolean) {  //если создаем конструктор, то далее необходимо передать в
    // инициализациию то же количество аргументов, но инициализировать класс enum снаружи нельзя
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true); //точка с запятой означает, что мы закончили перечисление и позволяет далее создавать методы Enum

    fun printDayType() {  //методы будут доступны при обращении к любому из элементов enum
        if (isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }
}

enum class CoffeeType(
    val cost: Double,
    val coffeeBase: String,
    val recommendedSugar: Int,
    val hasMilk: Boolean = false,
) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0);

    fun description() =
        "The $coffeeBase ${if (hasMilk) "with" else "without"} milk costs \$$cost and is best with $recommendedSugar spoons of sugar."
}

fun main() {
    println(NumsObject.ONE)


    val t: Nums = Nums.ONE
    println(Nums.ONE)
    for (n in Nums.entries) { //entries в данном случае внутренее свойство Enum
        println(n)
    }
    println(DayOfWeek.WEDNESDAY.printDayType())
    println(DayOfWeek.WEDNESDAY.isWeekend) //доступно, так как поле не объявлено private
}

fun printNum(num: Nums) {
    when (num) {
        Nums.ONE -> println(1)
        Nums.TWO -> println(2)
        Nums.THREE -> println(3)
    }
}