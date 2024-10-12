package org.st412m.kotlincourse.lesson12

fun main(){

}

fun sayHello() {
    println("Hello, world!")
}

fun greetUser(name: String) {
    println("Hello, $name!")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int) {
    println("Sum of $a and $b is ${a + b}")
}

fun multiply(a: Int, b: Int): Int = a * b // так пишем только если код функции помещается в одну строку


private fun calculateDiscount(price: Double): Double {  // приватная функция она доступна только внутри этого файла
    return price * 0.1
}

fun finalPrice(price: Double): Double {  // это функцию можно вызвать из любого файла в модуле(файлы сбоку)
    val discount = calculateDiscount(price)
    return price - discount
}
fun findValue(numbers: List<Int>, target: Int) {
    for (number in numbers) {
        if (number == target) {
            println("Value found: $number")
            return  // сразу выйдет из функции, если написать break, то цикл завершится, а функция продолжится
        }
        println(number)
    }
    println("Value not found")
}

fun doSomething(){} // не принимает аргументов и ничего не выводит
fun doSomething1() = Unit  // то же самое

fun getUserName(): String {
    return ""
}

fun printGreeting(greet: String){}

fun calculateArea(a: Double, b: Double): Double {
    return 0.0
}
fun findMax(a: Int, b: Int): Int = a + b

fun isNullOrEmpty(a: String?): Boolean {
    return true
}

fun calcDiscount(merch: List<String>, sum: Int?): Double?{
    return null
}

fun sum(a: Double, b: Double, flag: Boolean): Double {
    return if(flag) {
        a + b
    } else {
        a - b
    }
}

fun getMax(a: Int, b: Int) = if (a > b) a else b

fun printPositiveNumber(a: List<Int>) {
    for (i in a.indices) {
        if (a[i] > 0) {
            println(a[i])
        } else return Unit
    }
    println("конец")
}

fun replaceString(strings: MutableList<String>, str: String) {
    for (i in strings.indices) {
        if (strings[i] == str) {
          strings[i] = str.uppercase()
          return
        }
    }
}
private fun checkSize(size: Int, nameArg: String) {
    if (size == 0) throw IllegalArgumentException("$nameArg не должно быть равным нулю")
}

private fun createRange(size: Int): IntProgression {
    return if (size > 0) {
        0..size
    } else {
        0 downTo size
    }
}

fun printMap1(xSize: Int, ySize: Int) {
    checkSize(xSize, "xSize")  // вызывается закомменченый код через privat fun
    checkSize(ySize, "ySize")
//    if (xSize == 0) throw IllegalArgumentException("xSize не должно быть равным нулю")
//    if (ySize == 0) throw IllegalArgumentException("ySize не должно быть равным нулю")
    val formatterSize = " $xSize".length
    val xRange = createRange(xSize) // тоже что выше
//        if (xSize > 0) {
//        0..xSize
//    } else {
//        0 downTo xSize
//    }
    val yRange = createRange(ySize)
//        if (ySize > 0) {
//        0..ySize
//    } else {
//        0 downTo ySize
//    }
    print(" ".repeat(formatterSize))
    for (i in xRange) {
        print("%${formatterSize}s".format(i))
    }
    println()
    for (i in yRange) {
        print("%${formatterSize}s".format(i))
        for (j in yRange) {
            val m = i * j
            val result = when {
                m % 2 == 0 -> if (m % 3 == 0) "." else "*"
                m % 5 == 0 -> if (i < 0) "-" else "+"
                else -> "?"
            }
            print("%${formatterSize}s".format(result))
        }
        println()
    }
}