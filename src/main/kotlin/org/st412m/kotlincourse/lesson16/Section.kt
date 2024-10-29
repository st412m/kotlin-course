package org.st412m.kotlincourse.lesson16

class Section(
    val type: String,
    val capacity: Int
){

    private val items = mutableListOf<Item>()

    fun addItem(item: Item): Boolean {
        val itemVolume = convertWeightToVolume(item)
        if (getFreeSpace() >= itemVolume) {
            items.add(item)
            return true
        }
        return false
    }

    fun findItemByName(name: String): Item? {
        if (name.isEmpty()) {
            return items.firstOrNull()  // Только для пустой строки возвращаем первый элемент
        }
        return items.find { it.name == name }  // Для непустой строки ищем только по имени
    }

    fun remove(item: Item): Boolean {
        return items.remove(item)
    }

    fun getFreeSpace(): Int {
        return capacity - items.sumOf {convertWeightToVolume(it)}
    }

    fun formatData(): String {
        return """
    type: $type
    capacity: $capacity
    free: ${getFreeSpace()}
    items:
       ${items.joinToString("\n\t\t")}
       """.trimIndent()
    }

    private fun convertWeightToVolume(item: Item): Int {
        return (item.weight / conversionFactors.getValue(item.type)).toInt()
    }

}