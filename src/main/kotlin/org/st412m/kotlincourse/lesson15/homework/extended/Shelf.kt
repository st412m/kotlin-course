package org.st412m.kotlincourse.lesson15.homework.extended
/*
Характеристики:
Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
Список предметов (items): хранит названия предметов на полке.

Методы:
Добавление Предмета (addItem):
Принимает название предмета.
Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
Удаление Предмета (removeItem):
Принимает название предмета.
Удаляет предмет, если он найден на полке.
Возвращает true, если предмет был удален, и false, если такой предмет не найден.
Проверка Вместимости (canAccommodate):
Принимает название предмета.
Определяет, вместится ли предмет на полку.
Возвращает true, если предмет вместится, и false, если места недостаточно.
Получение списка предметов:
Возвращает неизменяемый список предметов
 */

class Shelf(
    val capacity: Int,
    val items: MutableList<String> = mutableListOf()
) {
    fun addItem(item: Item): Boolean {
        if (canAccommodate(item)) {
            items.add(item.name)
            println("${item.name} положен на полку")
            return true
        } else {
            return false
        }
    }

    fun removeItem(item: Item): Boolean {
        if (items.contains(item.name)) {
            items.remove(item.name)
            println("${item.name} удален с полки")
            return true
        }else {
            return false
        }
    }

    fun canAccommodate(item: Item): Boolean {
         val totalLength = items.sumOf { item.size }
         if (item.size + totalLength <= capacity) {
            println("${item.name} помещается")
            return true
        } else {
            println("Недостаточно места на полке")
            return false
        }
    }
    fun info(): List<String> {
         return items.toList()
    }

    fun freeSpace(): Int {
         return capacity - items.sumOf { it.length }
    }
}