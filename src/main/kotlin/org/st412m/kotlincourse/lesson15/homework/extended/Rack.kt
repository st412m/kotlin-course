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
            println("${shelves[index]} удалена")
            shelves.removeAt(index)
            return true
        } else {
            println("Такой полки не существует")
            return false
        }
    }

    fun addItem(item: Item): Boolean {
        val freeShelf = shelves.maxByOrNull {it.freeSpace()}
        if (freeShelf != null && freeShelf.canAccommodate(item)) {
            freeShelf.addItem(item)
            return true
        } else {
            println("Недостаточно места на всех полках для ${item.name}")
            return false
        }
    }

    fun removeItem(item: Item): Boolean {
        for (shelf in shelves) {
            if (item.name in shelf.info()) {
                shelf.removeItem(item)
                return true
            }
        }
        println("${item.name} не найден")
        return false
    }

    fun shelvesList(): List<Shelf> {
        return shelves.toList()
    }

    fun printContents() {
        for (shelf in shelves.indices) {
            println("Полка №$shelf, вместимостью ${shelves[shelf].capacity} единиц, свободное пространство - " +
                    "${shelves[shelf].freeSpace()} единиц, содержит ${shelves[shelf].info()}")
        }
    }

    fun advancedRemoveShelf(index: Int): Boolean {
        if (index !in shelves.indices) {
            println("Полки с индексом $index не существует")
            return false
        }
        val itemsForMoving = shelves[index].info().map { it -> Item(it, it.length) }
        val remainingItems = mutableListOf<String>()
        for (item in itemsForMoving) {
            val freeShelf = shelves.filterIndexed {  i, _ -> i != index }.maxByOrNull { it.freeSpace() }
            if (freeShelf != null && freeShelf.canAccommodate(item)) {
                freeShelf.addItem(item)
            } else {
                remainingItems.add(item.name)
                println("Не удалось разместить ${item.name}, пропускаем этот предмет")
            }
        }
        println("Удаляем полку. Остались предметы: ${remainingItems.toString()}")
        shelves.removeAt(index)
        return true
    }



}
