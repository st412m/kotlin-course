package org.st412m.kotlincourse.lesson6


fun main() {
    if (true) {
        println("true")  // так же else if после if - вложенные условия
    } else {
        println("false")
    }

    val intRange = 1..10  //диапазон всегда возрастающий
    val intRangeUntil = 1 until 10 // диапазон от 1 до 9
    val downTo = 10 downTo 1 //  нисходящий диапазон
    val charRange = 'd'..'r' // диапазон символов от кода до кода
    val inRange = 2 in intRange // проверка входит ли в диапазон, выдает булево значение
    val notInRange = 2 !in intRange // проверка если не входит ли в диапазон, выдает булево значение

    val score = 95
    when {
        score in 90..100 -> println("lf")   // упрощает код if если много проверок, но если в условиях много
        // кода(функции или чего-то там), то использовать if - else
        score in 70..79 -> println("dkfgjhkdg")
        else -> println("[htym")

    }

    val a = 3
    val b = 4
    val max = if (a > b) a else b // можно сразу присвоить переменной если "a" больше "b" то в переменную запишется
// "a" иначе "b"

    val score1 = 95
    val result = when (score1) {
        in 90..100 -> "lf"   // упрощает код проверок и одинаковых операторов
        in 70..79 -> "dkfgjhkdg"
        else -> "[htym"
    }


    println(result)
    fun getTimeOfDay(hour: Int): String {
        return if (hour in 0..4) {
            "ночь"
        } else if (hour in 5..11) {
            "утро"
        } else {
            "вечер"
        }
    }
}

// проверка пароля на надежность более 8 символов, разные символы и т.п.
fun checkPass(pass: String): Boolean {
    if (pass.length <= 8) return false
//    if (checkSymbols(pass)) return true
//
    return checkSymbols(pass)  // упрощение закоменченого кода выше
}

fun checkSymbols(pass: String): Boolean {
    return false
}

// число от 0 до 100

fun convertMark(mark: Int):String {

    return when(mark){
        in 0..20 -> "f"
        in 21..40 -> "e"
        in 41..60 -> "d"
        in 61..80 -> "c"
        in 81..90 -> "b"
        in 91..100 -> "a"
        else -> "invalid mark"
    }
 //return result

}
