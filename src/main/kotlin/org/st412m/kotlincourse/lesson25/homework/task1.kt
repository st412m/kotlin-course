package org.st412m.kotlincourse.lesson25.homework

/*
Задание 1. Создай константу в файле с текстом. Создай функцию, которая ничего не принимает и не возвращает и печатает
в консоль текст константы.
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Создай лямбда выражение без указания типа.
Проверь как функция работает
 */
const val LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
        "labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
        "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
        "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
        "mollit anim id est laborum."

fun main() {

    val nothingFun1 = fun(){
        println(LOREM_IPSUM)
    }

    val nothingFun2: () -> Unit = {
        println(LOREM_IPSUM)
    }

    val nothingFun3 = {println(LOREM_IPSUM)}

    nothingFun()
    nothingFun1()
    nothingFun2()
    nothingFun3()
}

fun nothingFun(){
    println(LOREM_IPSUM)
}