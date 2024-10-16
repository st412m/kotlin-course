package org.st412m.kotlincourse.lesson13

fun main() {
    /*
Подбери подходящий для задачи метод
Задачи на приведение коллекций к значению
isNotEmpty
getOrElse
joinToString
firstOrNull
size
isEmpty
minOrNull
contains
sum
average
maxOrNull
 */
    val numbersList = listOf(1, 3, -8, 0, 33, 100500, 69, 42, -1000, 18, 1, 30, 25, 1, 21)
    val numbersList1 = listOf<Int>()
    val textList = listOf("один", "два", "три", "четыре", "пять")


// Проверить, что размер коллекции больше 5 элементов.
    println(numbersList.getOrElse(5) { "В списке меньше пяти или 5 элементов" })

// Проверить, что коллекция пустая
    println(numbersList.isEmpty())
    println(numbersList1.isEmpty())

//Проверить, что коллекция не пустая
    println(numbersList.isNotEmpty())

//Взять элемент по индексу или создать значение если индекса не существует
    println(numbersList.getOrElse(10) { 100001 })


//Собрать коллекцию в строку
    println(numbersList.joinToString(separator = ", "))


//Посчитать сумму всех значений
    println(numbersList.sum())


//Посчитать среднее
    println(numbersList.average())


//Взять максимальное число
    println(numbersList.maxOrNull())

// Взять минимальное число
    println(numbersList.minOrNull())

//Взять первое число или null
    println(numbersList.firstOrNull { it == numbersList[0] })
    println(numbersList.getOrElse(0) { null })

//Проверить что коллекция содержит элемент
    println(numbersList.contains(100500))

    /*
Задачи на обработку коллекций
sorted
groupBy
distinct
take
takeLast
filter
filterNot
map
associate
sortedDescending
forEach
filterNotNull
 */


// Отфильтровать коллекцию по диапазону 18-30
    println(numbersList.filter { it in 18..30 })

// Выбрать числа, которые не делятся на 2 и 3 одновременно
    println(numbersList.filter { it % 3 == 0 && it % 2 == 0 })

// Очистить текстовую коллекцию от null элементов
    val numbersListNull = listOf(1, 3, -8, 0, 33, 100500, 69, null, 42, -1000, 18, 30, null, 25, 21)
    println(numbersListNull.filterNotNull())


// Преобразовать текстовую коллекцию в коллекцию длин слов
    println(textList.map {it.length.toInt()})

// Преобразовать текстовую коллекцию в мапу, где ключи - слова, а значения - перевёрнутые слова
    println(textList.associate {it to it.reversed()})

// Отсортировать список в алфавитном порядке
    println(textList.sorted())


// Отсортировать список по убыванию
    println(textList.sortedDescending())


// Распечатать квадраты элементов списка
    println(numbersList.map { it * it })

// Группировать список по первой букве слов
    println(textList.groupBy { it.first() })

// Очистить список от дублей
    println(numbersList.distinct())

// Взять первые 3 элемента списка
    println(numbersList.take(3))

// Взять последние 3 элемента списка
    println(numbersList.takeLast(3))


}
