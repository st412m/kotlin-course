package org.st412m.kotlincourse.lesson16

class Fridge(val capacity: Int) {

    private val sections = mutableListOf<Section>()

    fun addSection(section: Section): Boolean {
        return sections.size < capacity && sections.add(section)
    }

    fun removeSectionsByType(type: String): Boolean {
        return sections.removeAll { it.type == type }
    }

    fun removeSectionWithRedistribution(section: Section): List<Item> {
        val itemsToRedistribute = mutableListOf<Item>()
        var item = section.findItemByName("")
        while (item != null) {
            itemsToRedistribute.add(item)
            section.remove(item)
            item = section.findItemByName("")
        }
        val suitableSectionsSorted = sections
            .filter { it != section && it.type == section.type }
            .sortedByDescending { it.getFreeSpace() }

        val unplacedItems = mutableListOf<Item>()

        for (item in itemsToRedistribute) {
            var placed = false
            for (targetSection in suitableSectionsSorted) {
                if (targetSection.addItem(item)) {
                    placed = true
                    break
                }
            }
            if (!placed) {
                unplacedItems.add(item)
            }
        }

        if (unplacedItems.isNotEmpty()) {
            unplacedItems.forEach { section.addItem(it) }
        } else {
             sections.remove(section)
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
