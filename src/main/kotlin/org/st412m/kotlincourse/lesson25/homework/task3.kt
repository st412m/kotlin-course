package org.st412m.kotlincourse.lesson25.homework

import kotlin.String

/*
Задание 3. Создай функцию, которая принимает список строк и число, а возвращает список из строк, длина которых больше
или равна заданному числу. Если список пуст, нужно выкинуть исключение.
По аналогии с предыдущим заданием выполни трансформации и проверки.
 */


fun main() {
    val empty = mutableListOf<String>()
    val list = listOf("один", "два", "три", "четыре")

    val returnListLikeNum1 = fun(list: List<String>, number: Int): List<String> {
        require(list.isNotEmpty()) { "Список не должен быть пустым" }
        return list.filter { it.length >= number }
    }

    val returnListLikeNum2: (list: List<String>, number: Int) -> List<String> = { list, number ->
        require(list.isNotEmpty()) { "Список не должен быть пустым" }
        list.filter { it.length >= number }
    }

    val returnListLikeNum3 = { list: List<String>, number: Int ->
        require(list.isNotEmpty()) { "Список не должен быть пустым" }
        list.filter { it.length >= number }
    }


//    println(returnListLikeNum(empty, 4))
    println(returnListLikeNum(list, 4))
    println(returnListLikeNum1(list, 4))
    println(returnListLikeNum2(list, 4))
    println(returnListLikeNum3(list, 4))

}

fun returnListLikeNum(list: List<String>, number: Int): List<String> {
    require(list.isNotEmpty()) { "Список не должен быть пустым" }
    return list.filter { it.length >= number }
}