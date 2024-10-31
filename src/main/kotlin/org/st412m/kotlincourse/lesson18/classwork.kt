package org.st412m.kotlincourse.lesson18

object Colors {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[30m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

object Background {
    const val RESET = "\u001B[0m"
    const val BLACK = "\u001B[40m"
    const val RED = "\u001B[41m"
    const val GREEN = "\u001B[42m"
    const val YELLOW = "\u001B[43m"
    const val BLUE = "\u001B[44m"
    const val PURPLE = "\u001B[45m"
    const val CYAN = "\u001B[46m"
    const val WHITE = "\u001B[47m"
}

fun printColored(text: String, color: String, backgroundColor: String = "") {
    println("$color$backgroundColor$text${Colors.RESET}")
}


abstract class MusicalInstrument {

    abstract fun playNote(note: String)

    protected fun shortNote(note: String, color: String) {
        printColored("Play short note $note", color)
    }

    protected fun longNote(note: String, color: String) {
        printColored("Play long note $note", color)
    }
}

class Cello() : MusicalInstrument() {
    override fun playNote(note: String) {
        longNote(note, Colors.PURPLE)
    }

}

class Piano() : MusicalInstrument(){
    override fun playNote(note: String) {
        shortNote(note, Colors.BLUE)
    }
}

class Flute() : MusicalInstrument(){
    override fun playNote(note: String) {
        longNote(note, Colors.RED)
    }
}

class Calculator() {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    fun sum(a: Double, b: Double): Double {
        return a + b
    }
    fun sum(a:String, b:String): String {
        return a + b
    }
    fun sum(a: List<Int>, b: List<Int>): List<Int> {
        return a + b
    }
    fun sum(a: String, b:Boolean): String {
        return a + b.toString()
    }
}

fun main() {
    val cello = Cello()
//    cello.playNote("До")
    val piano = Piano()
//    piano.playNote("Ре")
    val flute = Flute()
//    flute.playNote("Ми")
    val orchestra: List<MusicalInstrument> = listOf(cello, piano, flute)
    orchestra.forEach{it.playNote("До")}

    val calc = Calculator()
    println(calc.sum(1, 2))
    println(calc.sum(0.1, 0.2))
    println(calc.sum("один", "два"))
    println(calc.sum(listOf(1,2), listOf(3,4)))
    println(calc.sum("один", true))
}

