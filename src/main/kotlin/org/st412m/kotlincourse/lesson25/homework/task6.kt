package org.st412m.kotlincourse.lesson25.homework

/*
Задание 6. Создай функцию расширение словаря из строк и чисел, которая принимает число и возвращает список ключей,
длина которых меньше их значений но больше заданного в функции аргумента. В случае если список получается пустой нужно
выкинуть исключение IllegalState.
По аналогии с предыдущим заданием выполни трансформации и проверки.
 */
fun main() {

    val map = mapOf(
        "яблоко" to 5,      // Длина строки больше 5
        "банан" to 6,       // Длина строки меньше 6
        "киви" to 4,        // Длина строки равна 4
        "груша" to 4,       // Длина строки больше 4
        "черника" to 9,     // Длина строки меньше 9
        "слива" to 4        // Длина строки больше 4
    )
    val map1 = mutableMapOf<String, Int>()

    val keyLessValue1 = fun Map<String, Int>.(arg: Int): List<String> {
        if (this.isEmpty()) throw IllegalStateException("Это словарь пустой")
        return this.filter { it.key.length < it.value && it.key.length > arg }
            .map { it.key }
    }


    val keyLessValue2: Map<String, Int>.(arg: Int) -> List<String> = { arg ->
        if (this.isEmpty()) throw IllegalStateException("Это словарь пустой")
        this.filter { it.key.length < it.value && it.key.length > arg }
            .map { it.key }
    }

    println(map1.keyLessValue(1))
    println(map.keyLessValue(3))
    println(map.keyLessValue1(3))
    println(map.keyLessValue2(3))

}

fun Map<String, Int>.keyLessValue(arg: Int): List<String> {
    if (this.isEmpty()) throw IllegalStateException("Это словарь пустой")
    return this.filter { it.key.length < it.value && it.key.length > arg }
        .map { it.key }
}