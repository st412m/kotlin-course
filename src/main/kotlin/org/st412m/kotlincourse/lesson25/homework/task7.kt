package org.st412m.kotlincourse.lesson25.homework

import jdk.internal.org.jline.keymap.KeyMap.key
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.iterator

/*
Задание 7. Создай функцию расширения словаря из списка и множества, которая принимает все известные тебе типы
(вспомни все что знаешь и под каждый тип создай аргумент) и возвращает строку. Функция должна распечатать все данные,
которые тебе в ней доступны и вернуть конкатенацию всех данных которые ей доступны (порядок неважен). Конкатенация -
это присоединение. Код должен быть отформатирован таким образом, чтобы легко читался.
По аналогии с предыдущим заданием выполни трансформации.
 */

fun main() {
    val map: Map<List<Any?>, Set<Any?>> = mapOf(
        listOf(1, "яблоко", null, listOf(2, 3, 4), mapOf("key1" to "value1")) to setOf(
            1.1, 2.2, 3.3,
            null,
            mapOf("какой-то ключ" to "какое-от значение")
        ),
        listOf("банан", null, listOf(10, 20)) to setOf(
            "фрукт", "еда",
            null,
            setOf(100, 200)
        ),
        listOf(1, false, null, mapOf("такое" to "сякое")) to setOf(
            "вынь", "положь",
            null,
            setOf(3.0, 4.0)
        )
    )
    val madness1 = fun Map<List<Any?>, Set<Any?>>.(arg: Any?): String {
        println("Аргумент: $arg")
        for ((k, v) in this) {
            println("Ключ: ${k.toString()}, Значение: ${v.toString()}")
        }
        return this.map { (k, v) -> k.toString() + v.toString() }
            .joinToString(", ")
    }

    val madness2: Map<List<Any?>, Set<Any?>>.(arg: Any?) -> String = { arg ->
        println("Аргумент: $arg")
        for ((k, v) in this) {
            println("Ключ: ${k.toString()}, Значение: ${v.toString()}")
        }
        this.map { (k, v) -> k.toString() + v.toString() }
            .joinToString(", ")
    }

    println(map.madness(1))
    println(map.madness1("раз"))
    println(map.madness1(null))


}

fun Map<List<Any?>, Set<Any?>>.madness(arg: Any?): String{
    println("Аргумент: $arg")
    for ((k, v) in this) {
        println("Ключ: ${k.toString()}, Значение: ${v.toString()}")
    }
    return this.map { (k, v) -> k.toString() + v.toString() }
        .joinToString(", ")
}