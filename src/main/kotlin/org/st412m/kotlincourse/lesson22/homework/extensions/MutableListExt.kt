package org.st412m.kotlincourse.lesson22.homework.extensions
/*
Создайте функцию-расширение для класса изменяемого списка элементов с дженериком, которая принимает два аргумента:
один типа дженерик, допускающий null, и другой типа число, и возвращает значение типа дженерик, допускающий null.
 */

fun <T> MutableList<T>.returnGenericNull(elem: T?, num: Int): T? {
    if (num !in indices) {
        println("Число вне диапазона индексов")
        return null
    }
    if (elem != null) {
        this[num] = elem
        print("Присвоили число элементу - ")
    } else {
        print("Нечего присваивать")
    }
    return this[num]
}
