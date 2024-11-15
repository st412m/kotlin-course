package org.st412m.kotlincourse.lesson22.extensions

fun String.removeSpaces(): String {
    return replace(" ", "")
}

fun String.funA(arg1: String, arg2: Int): Boolean {
    return true
}
