package org.st412m.kotlincourse.lesson22.homework.extensions
/*
Напишите функцию-расширение для класса символа, допускающего null, которая принимает три аргумента:
два типа число и один булево, и ничего не возвращает.
 */

fun Char?.returnNothing(arg1: Number, arg2: Number, flag: Boolean){
    if (this == null) {
        println("Нечего возвращать")
    } else {
        println("Символ: $this")
        println("Первый аргумент: $arg1")
        println("Второй аргумент: $arg2")
    }
}
