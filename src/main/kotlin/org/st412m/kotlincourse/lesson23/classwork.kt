package org.st412m.kotlincourse.lesson23

fun main() {
    val obj: Any = "Hello, World!"

    if (obj is String) {
        println("Объект является строкой")
    }

    if (obj !is Int) {
        println("Объект не является целым числом")
    }

    if (obj is String) {
        // obj автоматически приведён к String
        println(obj.uppercase()) // Метод toUpperCase() доступен, т.к. obj теперь String
    }
    val num: Any = 123
    //val str: String = num as String - нельзя так делать, так как num является Int и мы не можем заставить считать
    // его String
    val safeStr: String? = num as? String
    println(safeStr)

    val nullableStr: String? = "Kotlin"
    val nonNullableStr: String = nullableStr as String  // если строка окажется null то получим NullPointerException

    val mixedList: List<Any> = listOf("Kotlin", 42, 3.14, "Java", true)

    for (item in mixedList) {
        when (item) {
            is String -> println("$item - строка длиной ${item.length}")
            is Int -> println("$item - целое число")
            is Double -> println("$item - вещественное число")
            else -> println("Неизвестный тип")
        }
    }
    val flyingCar = FlyingCar()

    checkCapabilities(flyingCar)
/*
    val x: Any = "skdfjsdkfj"
    println(x as String)
    //println(x as Int) - ошибка
    if (x is Int) {
        println(x)
    } else {
        println("Это не строка")
    }
    val safeString: Int? = x as? Int
    println(safeString)
    println((x as? Int) ?: "это не число")

 */
    val y: Any = listOf("один", "два", "три")
    println(y as List<String>)
    println(y as List<Int>) // будет работать, потому что <Int> это дженерик и нет обращения к конкретным элементам,
    // а дженерики в рантайме не работают
//  println((y as List<Int>)[0]) // будет ошибка, так как обращаемся к конкретному элементу к которому обращаемся в
// листе, а так как у нас там стринги, но обращаемся мы как к Int, то ClassCastException
    if (y is List<*>) { // * - говорит о том, что там что угодно(WildCard), Any нельзя, так как Any это конкретный тип
        (y[0] as String).length
    }

    val z: String? = null
    println(z as? String)

}

interface Drivable {
    fun drive()
}

interface Flyable {
    fun fly()
}

class FlyingCar : Drivable, Flyable {
    override fun drive() {
        println("Едет как автомобиль")
    }

    override fun fly() {
        println("Летит как самолёт")
    }
}

fun checkCapabilities(drivable: Drivable) {
    drivable.drive()

    if (drivable is Flyable) {
        println("Этот объект также может летать!")
        drivable.fly()
    } else {
        println("Этот объект не может летать.")
    }
}
