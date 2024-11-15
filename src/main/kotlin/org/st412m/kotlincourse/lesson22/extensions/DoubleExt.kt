package org.st412m.kotlincourse.lesson22.extensions

fun Double?.funD(arg1: Double, arg2: String?): Double {
    return 0.0
}

fun Double.funE(): String {
    return "%.2f".format(this)
}