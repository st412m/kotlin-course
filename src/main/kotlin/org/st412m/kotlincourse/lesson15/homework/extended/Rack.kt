package org.st412m.kotlincourse.lesson15.homework.extended
/*
Класс Rack (Стеллаж)
Характеристики:

Список полок (shelves): хранит полки стеллажа.
Максимальное количество полок.

Методы:
Добавление Полки (addShelf):
Добавляет новую полку в стеллаж.
Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен.

Удаление Полки (removeShelf):
Принимает индекс полки для удаления.
Удаляет полку по указанному индексу.
Возвращает true, если полка была успешно удалена или false если она не существует.

Добавление Предмета (addItem):
Добавляет предмет на самую свободную полку.
Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.

Удаление Предмета (removeItem):
Находит и удаляет предмет с любой полки.
Возвращает true, если предмет был удален, и false, если такой предмет не найден.

Получение списка полок:
Возвращает неизменяемый список полок

Печать Содержимого (printContents):
Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов.
Информацию выводить в наглядном читаемом виде

Сложное удаление полки (advancedRemoveShelf):
Принимает индекс полки для удаления
Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается,
его нужно пропустить и попробовать разместить следующий.
Удаляет полку с оставшимися предметами
Возвращает true если полка удалена или false если полки не существует
 */


class Rack (
    private val capacity: Int,
    private val shelves: MutableList<Shelf> = mutableListOf(),
    ) {
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= capacity) {
            println("Места на стеллаже нет")
            return false
        }
        if (shelf in shelves) {
            println("$shelf установлена ранее")
            return false
        }
        shelves.add(shelf)
        println("$shelf добавлена")
        return true
    }

    fun removeShelf(index: Int): Boolean {
        if (index in shelves.indices) {
            shelves.removeAt(index)
            println("${shelves[index]} удалена")
            return true
        } else {
            println("Такой полки не существует")
            return false
        }
    }

    fun addItem(item: Item): Boolean {
        val freeShelf = shelves.maxByOrNull {}
    }

}