package org.st412m.kotlincourse.lesson18.homework
/*
Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
Выполнить перегрузку addToCart который:
Принимает два аргумента (itemId и количество amount)
Принимает словарь из id и количества и добавляет всё в корзину
Принимает список из id (добавляет по одной единице).
Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество
артикулов и общее количество всего товара в корзине.
 */

class ShoppingCart () {
    private val items: MutableMap<Int, Int> = mutableMapOf()

    fun addToCart(itemId: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: Int, amount: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(itemMap: Map<Int, Int>) {
        for ((itemId, amount) in itemMap) {
            addToCart(itemId, amount)
        }
    }
    fun addToCart(itemIds: List<Int>) {
        for (itemId in itemIds) {
            addToCart(itemId)
        }
    }
    override fun toString(): String {
        var result = "Корзина товаров:\n"
        var totalItems = 0
        var totalQuantity = 0

        for ((itemId, quantity) in items) {
            result += "Товар ID: $itemId, Количество: $quantity\n"
            totalItems++
            totalQuantity += quantity
        }

        result += "Всего товаров: $totalItems\n"
        result += "Общее количество: $totalQuantity\n"
        return result
    }
}