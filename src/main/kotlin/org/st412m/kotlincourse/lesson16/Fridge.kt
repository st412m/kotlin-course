package org.st412m.kotlincourse.lesson16

class Fridge(val capacity: Int) {

    private val sections = mutableListOf<Section>()

    fun addSection(section: Section): Boolean {
        return if (sections.size < capacity) {
            sections.add(section)
            true
        } else {
            false
        }
    }

    fun removeSectionsByType(type: String): Boolean {
        return sections.removeAll { it.type == type }
    }

    fun removeSectionWithRedistribution(section: Section): List<Item> {
        if (!sections.contains(section)) {
            return emptyList()
        }
        val itemsToRedistribute = mutableListOf<Item>()

        while (true) {
            val item = section.findItemByName("") ?: break
            itemsToRedistribute.add(item)
            section.remove(item)
        }
        sections.remove(section)
        val unplacedItems = mutableListOf<Item>()
        for (item in itemsToRedistribute) {
            val suitableSection = sections.filter { it.type == item.type }.maxByOrNull { it.getFreeSpace() }
            if (suitableSection?.addItem(item) != true) {unplacedItems.add(item)}
        }

        return unplacedItems
    }

    fun addItem(item: Item): Boolean {
            val suitableSection = sections.filter { it.type == item.type }.maxByOrNull { it.getFreeSpace() }

        return suitableSection?.addItem(item) ?: false
    }

    fun findItemByNameAndType(name: String, type: String): Item? {
        for (section in sections) {
            if (section.type == type) {
                val item = section.findItemByName(name)
                if (item != null) {
                    return item
                }
            }
        }
        return null
    }

    fun removeItem(item: Item): Boolean {
        return sections.any { section -> section.remove(item) }
    }

    fun removeAllItemsByName(name: String): Int {
        var totalRemoved = 0
        for (section in sections) {
            var item = section.findItemByName(name)
            while (item != null) {
                if (section.remove(item)) {
                    totalRemoved++
                }
                item = section.findItemByName(name)
            }
        }
        return totalRemoved
    }

    fun viewFridge() {
        println(sections.joinToString("\n\n") { it.formatData() })
    }
}
