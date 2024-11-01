package org.st412m.kotlincourse.lesson18.homework

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