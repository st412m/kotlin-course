package org.st412m.kotlincourse.lesson22.extensions

fun <T> List<T?>.isElementsNullOrEmpty(): Boolean {
    return this.all { it == null } || this.isEmpty()
}

fun List<Int>.funB(arg1: String?){}

fun <T> T.createList(n: Int): List<T> {
    return (0 until n).map { this }
}