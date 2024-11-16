package org.st412m.kotlincourse.lesson22.homework.extensions

/*
Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел.
 */

fun Array<Number>.returnPair(): Pair<Number, Number>? {
    if (this.size < 2 || this.isEmpty()) return null
    return Pair(this[0], this[1])
}
