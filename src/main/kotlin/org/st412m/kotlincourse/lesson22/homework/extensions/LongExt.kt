package org.st412m.kotlincourse.lesson22.homework.extensions
/*
Определите функцию-расширение для класса длинного числа, допускающее null, которая не принимает
аргументов и возвращает строку.
 */

fun Long?.returnSting(): String {
    if (this == null) return "нечего передавать"
    return "$this смотри собачка, какая хуйня"
}
