package org.st412m.kotlincourse.lesson21.homework
/*
Напишите класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления и получения
всех элементов.
 */

class ListHolder<T>(private val list: MutableList<T>) {
    fun addElement(element: T) {
        list.add(element)
    }

    fun getElements(): List<T> {
        return list
    }
}
