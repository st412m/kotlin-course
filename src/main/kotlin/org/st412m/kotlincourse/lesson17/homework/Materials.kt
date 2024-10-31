package org.st412m.kotlincourse.lesson17.homework
/*
Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только
для того, чтобы быть основой для подклассов.

Создай подклассы этого контейнера, которые будут добавлять строку material в какое-то определённое место.
Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными,
которые уже есть. То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
Третий класс должен добавлять элементы в список в алфавитном порядке. Если мы добавляем новый элемент в список,
то он должен встать где-то между другими элементами и занять место в соответствии с сортировкой по алфавиту.
Четвёртый класс должен принимать словарь из строк (ключи и значения). Каждая пара ключа и значения должна попадать
в контейнер следующим образом - ключ в начало, значение в конец.
 */


abstract class Materials {

    private val materials = mutableListOf<String>()

    fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterial(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class MaterialsBottom(): Materials(){
    fun addToBottom(material: String) {
        val currentMaterials = extractMaterial().toMutableList()
        addMaterial(material)
        currentMaterials.forEach { addMaterial(it) }
    }
}

class ThroughTheLine : Materials() {
    fun alternation(newMaterials: List<String>) {
        val currentMaterials = extractMaterial()
        val maxSize = maxOf(newMaterials.size, currentMaterials.size)
        val result = mutableListOf<String>()

        for (k in 0 until maxSize) {
            if (k < newMaterials.size) result.add(newMaterials[k])
            if (k < currentMaterials.size) result.add(currentMaterials[k])
        }

        result.forEach { addMaterial(it) }
    }
}

class Alphabetical : Materials() {
    fun addAlphabetically(material: String) {
        val currentMaterials = extractMaterial().toMutableList()
        currentMaterials.add(material)
        currentMaterials.sort()
        currentMaterials.forEach { addMaterial(it) }
    }
}

class KeyValue : Materials() {
    fun addKeyValuePairs(pairs: Map<String, String>) {
        val currentMaterials = extractMaterial().toMutableList()
        pairs.forEach{(key, value) ->
            currentMaterials.add(0, key)
            currentMaterials.add(value)
        }
        currentMaterials.forEach { addMaterial(it) }
    }
}
//