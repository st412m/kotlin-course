package org.st412m.kotlincourse.lesson13

fun main(){

    val list = listOf(8, 56, 23, 87, 12, 18, 11)
    val filtered1 = filter(list)
    println(filtered1)

    val filtered2 = list.filter { it in 7..17 }   // фильтрует список, делает тоже что и fun filter(collection: List<Int>): List<Int>
    println(filtered2)
//---------------------------------------------------
    val numbers = listOf(-1, 2, -3, 4, -5)
    val positiveNumbers = numbers.filter { it > 0 } // тоже что и выше, но фильтрует на положительные числа
    println(positiveNumbers)
//---------------------------------------------------
    val notPositiveNumbers = numbers.filterNot { it > 0 }  // фильтр обратного действия т.е. сделает наоборот тому
    // что в скобках
    println(notPositiveNumbers)
//---------------------------------------------------
    val nullableList = listOf(1, null, 2, null, 3)
    val nonNullList = nullableList.filterNotNull()  // отфильтрует из списка налбл значения, т.е. уберет все null
    println(nonNullList)
//---------------------------------------------------
    val firstPositive = numbers.firstOrNull { it > 0 } // отфильтует по скобкам и вернет первое значение, но если
    // внутри ничего не соответсвует, то вернет null
    println(firstPositive)
//---------------------------------------------------
    val elementOrElse = numbers.getOrElse(10) { -1 } //получить элемент по индексу(в данном случае 10), но если
    // такого индекса нет(вне диапазона) то вернет значение {-1} - ну, или чего назначишь, например it - вернет индекс
    println(elementOrElse)
//---------------------------------------------------
    val incrementedNumbers: List<String> = numbers.map { "$it%" } // преобразует что угодно во что угодно
    println(incrementedNumbers)

//---------------------------------------------------
    val numberSquareMap = numbers.associate { it to it * it }  // создает словарь где it - ключ, а it*it - значения
    println(numberSquareMap)
//---------------------------------------------------
    val multipleList = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6)
    )

    val flattenList = multipleList.flatten()  // склеивает списки в один общий список
//---------------------------------------------------

    val flattenListAfterMapping = multipleList.flatMap { list1: List<Int> ->  // комбинированный метод
        list1.map { it * 2 }
    }
    println(flattenListAfterMapping)
//---------------------------------------------------

    val numbersString = numbers.joinToString(separator = ", ") // преобразуем числа в строку через разделитель ", "

    println(numbersString)
    val numbersString1: String = numbers.joinToString(separator = " % ") { "$it * $it"} // после скобок можно добавить {} и будет выполнено некое преобразование

    //---------------------------------------------------
    val sortedNumbers = numbers.sorted()  // отсортирует по возрастанию
    println(sortedNumbers)

//---------------------------------------------------
    numbers.forEach {   // цикл for
        println(it)
    }
//---------------------------------------------------
    val sumOfNumbers = numbers.sum()   // считает сумму числовых списков (только числа)
    println(sumOfNumbers)
//---------------------------------------------------
    val averageOfNumbers = numbers.average()  // среднее значение всегда double
    println(averageOfNumbers)
//---------------------------------------------------
    val maxNumber = numbers.maxOrNull()  // вернет макимальное значение либо null
    println(maxNumber)
//---------------------------------------------------
    val minNumber = numbers.minOrNull()  // вернет минимальное значение либо null
    println(minNumber)
//---------------------------------------------------
    val groupedBySign = numbers.groupBy { if (it > 0) "Positive" else "Negative" }  // создает мапу с ключами в
    // кавычках и значениями, которые соответствуют тому что  в скобках
    println(groupedBySign)
//---------------------------------------------------
    val distinctNumbers = listOf(1, 2, 2, 3, 3, 3, 4).distinct()  // удалит дубликаты
    println(distinctNumbers)
//---------------------------------------------------
    val numbers1 = listOf(1, 2, 3, 4, 5)
    println(numbers1.take(3))  // возьмет количество элементов которое указано(если указать больше чем есть, то вернет
// только те что есть)(первые)
//-------------------------------------------------------
    val numbers2 = listOf(1, 2, 3, 4, 5)
    println(numbers2.takeLast(3))  // возьмет последние 3 значение
//-------------------------------------------------------
    println(numbers.size) // вернет размер списка

    val numbers3 = listOf(1, 2, 3, 4, 5)
    numbers3.isEmpty() // вернет true, если список пуст
    numbers3.isNotEmpty() // вернет true, если есть хоть одно значение
}

fun filter(collection: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in collection) {
        if (i in 7..17) result.add(i)
    }
    return result
}
