package org.st412m.kotlincourse.lesson11

import java.time.LocalDate  // это бонус к заданию 9, пришлось, так как в котлин нет встроенной функции для получения
// текущего года

/*
Задания в целом повторяют задачи с урока и служат для закрепления навыка, поэтому стараемся выполнять без переписывания
с урока.
 */
fun main() {
    /*
Задание 1: Создание Пустого Словаря
Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
 */
    println("-----Задание 1-----")
    val map1 = mapOf<Int, Int>()
    println(map1)

    /*
Задание 2: Создание и Инициализация Словаря
Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
 */
    println("-----Задание 2-----")
    val map2 = mapOf<Float, Double>(1f to 1.0, 2f to 2.0, 3f to 3.0)
    println(map2)

    /*
Задание 3: Создание Изменяемого Словаря
Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
 */
    println("-----Задание 3-----")
    val map3 = mutableMapOf<Int, String>()
    println(map3)

    /*
Задание 4: Добавление Элементов в Словарь
Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
 */
    println("-----Задание 4-----")
    val list1 = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
        "u", "v", "w", "x", "y", "z")
    val map4 = mutableMapOf<Int, String>()
    for (i in list1.indices) {
        map4[i] = list1[i]
    }
    println(map4)

    /*
Задание 5: Получение Значений из Словаря
Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом,
которого в словаре нет.
 */
    println("-----Задание 5-----")
    println(map4[1])
    println(map4[33])

    /*
Задание 6: Удаление Элементов из Словаря
Удалите определенный элемент из изменяемого словаря по его ключу.
 */
    println("-----Задание 6-----")
    map4.remove(10)
    println(map4)


    /*
Задание 7: Перебор Словаря в Цикле
Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь
обработать деление на 0 (в этом случае выведи слово “бесконечность”)
 */
    println("-----Задание 7-----")
    val key1 = listOf<Double>(15.32, 14.09, 21.14, 67.95, 13.33, 19.60, 9.75, 61.70, 79.20, 66.56)
    val value1 = listOf<Int>(59, 35, 19, 15, 13, 16, 60, 0, 89, 68)
    var map7 = mutableMapOf<Double, Int>()
    println(sort(key1, value1, map7))


    /*
Задание 8: Перезапись Элементов Словаря
Измените значение для существующего ключа в изменяемом словаре.
 */
    println("-----Задание 8-----")
    var map8 = mutableMapOf<Int, String>(1 to "Лупа", 2 to "получил", 3 to "за", 4 to "Пупу")
    println(map8)
    map8[1] = "Пупа"
    map8[4] = "Лупу"
    println(map8)

    /*
Задание 9: Сложение Двух Словарей
Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
 */
    println("-----Задание 9-----")
    val mapNine = mapOf(1 to "Value1", 2 to "Value2", 3 to "Value3", 4 to "Value4", 5 to "Value5")
    val mapNineOne = mapOf(6 to "Item6", 7 to "Item7", 3 to "Item8", 9 to "Item9", 1 to "Item10")
    println(unification(mapNine, mapNineOne))

    /*
Задание 10: Словарь с Сложными Типами
Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов
в этот словарь.
 */
    println("-----Задание 10-----")
    val map10 = mapOf<String, List<Int>>("один" to listOf(1, 2, 3), "два" to listOf(4, 5, 6))
    println(map10)


    /*
Задание 11: Использование Множества в Качестве Значения
Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь.
Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку.
Распечатай полученное множество.
 */
    println("-----Задание 11-----")
    val set1 = mutableSetOf("Яблоко", "Банан", "Вишня")
    val set2 = mutableSetOf("Апельсин", "Виноград", "Черешня")
    val set3 = mutableSetOf("Гвоздь", "Камень", "Электродрель")
    val map11 = mapOf<Int, MutableSet<String>>(1 to set1, 2 to set2, 3 to set3)
    println(map11)
    val updSet3 = map11[3]
    updSet3?.add("Кочегар")
    println(updSet3)
    println(map11)

    /*
Задание 12: Поиск Элемента по Значению
Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать
цифру 5 в качестве первого или второго значения.
 */
    println("-----Задание 11-----")
    val pair1 = 1 to 2
    val pair2 = 3 to 4
    val pair3 = 5 to 6
    val pair4 = 7 to 5
    val map12 = mapOf(pair1, pair2, pair3, pair4)
    println(fivePair(map12))


    /*
======
Напиши решения задач. В каждом случае нужно проанализировать и подобрать оптимальный тип словаря.
Задание 6: Словарь Библиотека
Ключи - автор книги, значения - список книг
 */

    val map13 = mutableMapOf<String, MutableList<String>>()

    /*
Задание 12: Справочник Растений
Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
 */

    val map14 = mutableMapOf<String, List<String>>()

    /*
Задание 8: Четвертьфинала
Ключи - названия спортивных команд, значения - списки игроков каждой команды
 */

    val map15 = mutableMapOf<String, MutableList<String>>()

    /*
Задание 9: Курс лечения
Ключи - даты, значения - список препаратов принимаемых в дату
 */

    val map16 = mutableMapOf<Long, MutableList<String>>()

    /*
Задание 10: Словарь Путешественника
Ключи - страны, значения - словари из городов со списком интересных мест.
 */
    val map17 = mutableMapOf<String, MutableMap<String, MutableList<String>>>()
}


// -----Задание 7-----
fun sort(key1: List<Double>, value1: List<Int>, map7: MutableMap<Double, Int>): List<String> {
    var tempList = mutableListOf<String>()
    for (i in key1.indices) {
        map7[key1[i]] = value1[i]
    }
    for ((k, v) in map7) {
        if (v != 0) {
            tempList.add((k / v).toString())
        } else tempList.add("жопа")
    }
    return tempList
}

// -----Задание 9-----
fun unification(mapNine: Map<Int, String>, mapNineOne: Map<Int, String>): MutableMap<Int, String> {
    var uniMap = mutableMapOf<Int, String>()
    var year = LocalDate.now().year
    for ((k, v) in mapNine) {
        uniMap[k] = v
    }
    for ((k, v) in mapNineOne){
        if (k in uniMap && (year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            uniMap[k] = mapNine[k].toString()
        } else {
            uniMap[k] = v
        }
    }
    return uniMap
}

// -----Задание 12-----
fun fivePair(map12: Map<Int, Int>): Any {
    val pairsList = mutableListOf<String>() // Список для хранения строк с парами
    for ((k, v) in map12) {
        if (k == 5 || v == 5) {
            pairsList.add("$k: $v")
        }
    }
    if (pairsList.isNotEmpty()) return pairsList
        else return "нет таких пар"
}

