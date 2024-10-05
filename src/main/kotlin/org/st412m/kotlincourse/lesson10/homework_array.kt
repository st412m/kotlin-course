package org.st412m.kotlincourse.lesson10
//Работа с массивами Array

fun main() {
    /*
Задание 1: Создание и Инициализация Массива
Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
*/
    println("---задача 1----")
    val array1 = arrayOf(1, 2, 3, 4, 5)
    println(array1.toList())

    /*
Задание 2: Создание Пустого Массива
Создайте пустой массив строк размером 10 элементов.
*/
    println("---задача 2----")
    val array2 = Array(10) { "" }
    println(array2.toList())

    /*
Задание 3: Заполнение Массива в Цикле
Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
*/
    println("---задача 3----")
    val array3 = Array(5) { 0.0 }
    for (i in array3.indices) {
        array3[i] = (i * 2).toDouble()
    }
    println(array3.toList())

    /*
Задание 4: Изменение Элементов Массива
Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его
индексу, умноженному на 3.
*/
    println("---задача 4----")
    val array4 = Array(5) { 0 }
    for (i in array3.indices) {
        array4[i] = (i * 3)
    }
    println(array4.toList())

    /*
Задание 5: Работа с Nullable Элементами
Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
*/
    println("---задача 5----")
    val array5 = arrayOfNulls<String?>(3)
    array5[0] = null
    array5[1] = "два"
    array5[2] = "три"
    println(array5.toList())

    /*
Задание 6: Копирование Массива
Создайте массив целых чисел и скопируйте его в новый массив в цикле.
*/
    println("---задача 6----")
    val array6 = arrayOf(1, 2, 3, 4, 5)
    val newArray6 = Array(5) { 0 }
    for (i in array6.indices) {
        newArray6[i] = array6[i]
    }
    println(newArray6.toList())

    /*
Задание 7: Разница Двух Массивов
Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
*/
    println("---задача 7----")
    val array7 = arrayOf(3, 4, 5, 6, 7)
    val secondArray7 = arrayOf(1, 2, 3, 4, 5)
    val newArray7 = Array(5) { 0 }
    for (i in array7.indices) {
        newArray7[i] = array7[i] - secondArray7[i]
    }
    println(newArray7.toList())

    /*
Задание 8: Поиск Индекса Элемента
Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, возвращаем -1.
Реши задачу через цикл while.
*/
    println("---задача 8----")
    val array8 = arrayOf(0, 1, 2, 3, 4, 5, 6, 7)
    var i = 0
    while (i < array8.lastIndex) {
        if (array8[i] == 5) {
            println(array8[i])
        } else {
            println(-1)
        }
        i++
    }

    /*
Задание 9: Перебор Массива
Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого
элемента должно быть написано “чётное” или “нечётное”.
*/
    println("---задача 9----")
    val array9 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (index in array9.indices) {
        if (array9[index] % 2 == 0) {
            println("${array9[index]} - чётное")
        } else {
            println("${array9[index]} - нечётное")
        }
    }

    /*
Задание 10: Поиск Значения в Массиве по вхождению
Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором
принятая строка является подстрокой (метод contains()). Верни найденный элемент из функции в виде строки.
*/
    println("---задача 10----")
    val array10 = arrayOf("раз", "два", "три", "четыре", "пять" )
    val searchString = "четыре"
    println(search(array10, searchString))
}
fun search(array10: Array<String>, searchString: String?): String {
    if (searchString != null) {
        for (i in array10) {
            if (i.contains(searchString)) {
                return i
            } else{
                Unit
            }
        }
    }
    return "не найдено"
}



