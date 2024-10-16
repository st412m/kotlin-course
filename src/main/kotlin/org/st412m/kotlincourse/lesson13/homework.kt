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
    println(textList.map { it.length.toInt() })

// Преобразовать текстовую коллекцию в мапу, где ключи - слова, а значения - перевёрнутые слова
    println(textList.associate { it to it.reversed() })

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


    /*
Задание 2: Характеристика числовой коллекции
Написать метод, который принимает коллекцию чисел и возвращает строку с текущим состоянием коллекции используя конструкцию when
Если коллекция пустая - “Пусто”
Если количество элементов меньше пяти - “Короткая”
Если коллекция начинается с 0 - “Стартовая”
Если сумма всех чисел больше 10000 - “Массивная”
Если среднее значение равно 10 - “Сбалансированная”
Если длина строки образованная склеиванием коллекции в строку равна 20 - “Клейкая”
Если максимальное число меньше -10 - “Отрицательная”
Если минимальное число больше 1000 - “Положительная”
Если содержит одновременно числа 3 и 14 - “Пи***тая”
Иначе - “Уникальная”

Вызвать метод с данными, подходящими под каждую из веток
 */
    println("-----Задание 2 ------")
    val empty = listOf<Int>()
    println(characteristicListNumbers(empty))
    val short = listOf<Int>(1, 2, 3)
    println(characteristicListNumbers(short))
    val start = listOf<Int>(0, 1, 2, 3, 4, 5)
    println(characteristicListNumbers(start))
    val massive = listOf<Int>(10, 100, 1000, 10000, 100000)
    println(characteristicListNumbers(massive))
    val balanced = listOf<Int>(10, 10, 10, 10, 10, 10)
    println(characteristicListNumbers(balanced))
    val sticky = List(20) { 1 }
    println(characteristicListNumbers(sticky))
    val negative = listOf<Int>(-100, -99, -10, -50, -60)
    println(characteristicListNumbers(negative))
    val positive = listOf<Int>(1001, 10000, 100000, 1000000, 10000001)
    println(characteristicListNumbers(positive))
    val pussy = listOf<Int>(1, 2, 3, 10, 14)
    println(characteristicListNumbers(pussy))
    val unique = listOf<Int>(1, 1, 1, 1, 1)
    println(characteristicListNumbers(unique))


    /*
Задание 3: Анализ Учебных Оценок
Начальные значения: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
Цель: Отфильтровать удовлетворительные оценки (>=60), отсортировать оставшиеся по возрастанию и взять первые 3.
 */

    /*
Задание 4: Создание каталога по первой букве.
Начальные значения: val list = listOf(
    "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик",
    "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод",
     "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка",
      "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир",
      "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка")

Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве.
 */

    /*
Задание 5: Подсчёт средней длины слов в списке.
Начальные значения из задачи 3.
Цель: Перевести все слова в количество букв, подсчитать среднее значение.
Вывести форматированный текст с двумя знаками после запятой.
*/

    /*
Задание 6: Категоризация чисел.
Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”).
 */

    /*
Задание 7: Поиск первого подходящего элемента
Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60)
Цель: Найти первый возраст в списке, который соответствует условию (больше 18), преобразовать его к строке,
или вернуть сообщение "Подходящий возраст не найден".
 */

}

fun characteristicListNumbers(numList: List<Int>): String {
    return when {
        numList.isEmpty() -> "Пусто"
        numList.size < 5 -> "Короткая"
        numList.getOrNull(0) == 0 -> "Стартовая"
        numList.sum() > 10000 -> "Массивная"
        numList.average() == 10.0 -> "Сбалансированная"
        numList.joinToString("").length == 20 -> "Клейкая"
        numList.maxOrNull()!! <= -10 -> "Отрицательная"
        numList.minOrNull()!! > 1000 -> "Положительная"
        numList.contains(3) && numList.contains(14) -> "Пиздатая"
        else -> "Уникальная"
    }
}