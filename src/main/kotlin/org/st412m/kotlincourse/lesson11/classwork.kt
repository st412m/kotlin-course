package org.st412m.kotlincourse.lesson11

fun main() {

    val pair: Pair<Int, String>  = 1 to "a" // пара может состоять из любых 2 типо(включая составные типы, List и т.п.)
    val pair2 = Pair(2, "a")  // неизменяемый
    println(pair.first)
    println(pair.second)

    val emptyMap: Map<String, String> = mapOf<String, String>()  //словарь(оно же мапа)

    // Способы инициализации словарей
    val capitals = mapOf(
        "Россия" to "Москва",
        "Франция" to "Париж"
    )

    val a1 = "Россия" to "Москва"
    val a2 = "Франция" to "Париж"
    val capitals2 = mapOf(a1, a2)


    val capitals3 = mutableMapOf(     // изменяемый словарь
        "Россия" to "Москва",
        "Франция" to "Париж"
    )

    val capitalOfRussia = capitals["Россия"]  // доступ по ключу

    capitals3["Германия"] = "Берлин"  // добавление в словарь [ключ] = значение, либо замена по ключу
    capitals3.remove("Франция") // удаление по ключу

    for (entries in capitals3) {
        println("(${entries.key} : ${entries.value}")   // перебор словаря
    }
    for ((country, capital) in capitals) {   // перебор словаря
        println("$country: $capital")
    }

    // ключ может быть null

    val map1 = mapOf<String, Int>()
    val map2 = mapOf<Int, String>(1 to "один", 2 to "два")
    val map3 = mutableMapOf(3 to "три")
    map3[4] = "четыре"
    println(map3[3])
    println(map3[2])  // если ключа нет - вернет null, т.е. всегда возвращается налбл значение
    map3.remove(3)

    for (entries in map2) {
        println("${entries.key} : ${entries.value}")
    }
    for ((key, value) in map2) {
        println("$key: $value")
    }

    val map4 = mapOf<String, List<Int>>("List1" to listOf(1, 2, 3))

}

fun searchKey(map2: Map<String, String>, word: String): String {
    for((k, v) in map2) {
        if (v == word) return k
    }
    return "ключа нет"
}