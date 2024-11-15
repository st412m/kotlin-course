package org.st412m.kotlincourse.lesson22

import org.st412m.kotlincourse.lesson22.extensions.*



fun main() {
    val result = "String with spaces".removeSpaces()
    println(result)

    val s: List<Int?> = listOf(1, null)
    s.isElementsNullOrEmpty()

    println("asjdhjasd".funA("wewrw", 1))
    listOf(1, 2, 3).funB(null)
    mapOf("sdkfjh" to 1, "sfdf" to 2).funC("sdfsdf", true)

    var num2 = null
    println(setOf("sdfs", "fghf").funF("dsdf"))

    val num: Double = 58.123123
    println("%.2f".format(num))
    num.funE()
    println(num.createList(8))
}

