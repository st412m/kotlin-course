package org.st412m.kotlincourse.lesson25

fun main() {

    val function11 = fun() {
        println("It`s working")
    }

    val function12: () -> Unit = {
        println("It`s working")
    }

    val function13 = { println("It`s working") }

    val function21 = fun(str: String): Int {
        return str.length
    }

    val function22: (String) -> Int = { it.length }

    val function23 = { str: String -> str.length }

    val function31 = fun String.(a: Int, b: Int): Boolean {
        println(this)
        println(a)
        println(b)
        return a == b
    }
    val function32: String.(Int, Int) -> Boolean = { a, b ->
        println(this)
        println(a)
        println(b)
        a == b
    }

    println("kotlin".function32(1, 2))

    val function41 = fun(numbers: List<Int>): Int {
        return numbers.filter { it > 0 }.sum()
    }

    val function42: (List<Int>) -> Int = { list -> list.filter { it > 0 }.sum() }

    val function43 = { list: List<Int> -> list.filter { it > 0 }.sum() }

    val function51 = fun Set<Int>.(): Set<Int> {
        return this.filter { it % 2 == 0 }.toSet()
    }

    val function52: Set<Int>.() -> Set<Int> = {
        filter { it % 2 == 0 }.toSet()
    }

}

fun function1() {
    println("It`s working")
}

fun function2(str: String): Int {
    return str.length
}

fun String.function3(a: Int, b: Int): Boolean {
    println(this)
    println(a)
    println(b)
    return a == b
}

fun function4(numbers: List<Int>): Int {
    return numbers.filter { it > 0 }.sum()
}

fun Set<Int>.filterEven(): Set<Int> {
    return this.filter { it % 2 == 0 }.toSet()
}