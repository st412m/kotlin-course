package org.st412m.kotlincourse.lesson14

fun main(){

    val fruitsPrices = mapOf("apple" to 2.99, "banana" to 1.99, "cherry" to 3.99)

    for (entry in fruitsPrices.entries) {   // перебор словаря
        println("Key: ${entry.key}, Value: ${entry.value}")
    }


    for ((fruit, price) in fruitsPrices) {   // перебор словаря (деструктуризация)
        println("Key: $fruit, Value: $price")
    }

    val entries: Set<Map.Entry<String, Double>> = fruitsPrices.entries  //получение элементов из словаря
    val keys: Set<String> = fruitsPrices.keys
    val values: Collection<Double> = fruitsPrices.values

    val priceOfPearOrElse = fruitsPrices.getOrElse("pear") { throw IllegalArgumentException() } // получение значения
    val priceOfApple = fruitsPrices.getValue("apple")
    val priceOfPearOrDefault = fruitsPrices.getOrDefault("pear", 0.0)

    val fruitsWithoutBanana = fruitsPrices - "banana"      // изменение словарей "-" - это метод, который удалит ключ
    // и значение по ключу
    val fruitsWithPineapple = fruitsPrices + ("pineapple" to 3.5) // "+" - добавит в словарь новую пару
    val mutableFruits = fruitsPrices.toMutableMap()

    mutableFruits["kiwi"] = 2.75 // Добавление элемента
    mutableFruits.putAll(mapOf("lime" to 1.1, "avocado" to 1.9))  // добавить все элементы одного словаря в другой
    mutableFruits.remove("apple") // Удаление элемента
    mutableFruits.clear()  // очистить словарь

    val containsApple = fruitsPrices.containsKey("apple")  // проверяет наличие ключа
    val containsValue1_5 = fruitsPrices.containsValue(1.5) // проверяет наличие значения
    val isEmpty = fruitsPrices.isEmpty() // проверяет пустой ли словарь
    val isNotEmpty = fruitsPrices.isNotEmpty()  // не пустой
    val areAllFruitsExpensive = fruitsPrices.all { it.value > 1.0 } // все элементы должны соответстовать условию -
    // Boolean  - логическое и &&
    val isAnyFruitCheap = fruitsPrices.any { it.value < 1.0 } // любой элемент соответствует условию, так же Boolean
// - логическое или ||

    val filteredByPrice = fruitsPrices.filter { it.value > 1.0 }
    val filteredByKeys = fruitsPrices.filterKeys { it.startsWith("a") }
    val filteredByValues = fruitsPrices.filterValues { it < 2.0 }
    val filteredNotApple = fruitsPrices.filterNot { it.key == "apple" }
    val countExpensiveFruits = fruitsPrices.count{ it.value > 1.5 } // если count() - то выведет количество элементов
// словаря

    val increasedPrices = fruitsPrices.mapValues { it.value * 1.1 } // преобразует значения словаря для каждого ключа
    val fruitNamesUppercase = fruitsPrices.mapKeys { it.key.uppercase() } // преобразует ключи
    val fruitsList = fruitsPrices.map { "${it.key} costs ${it.value}" } // преобразует словарь в список

    val toMap = mutableFruits.toMap() // преобразует изменяемый словарь в неизменяемый
    val toMutableMap = fruitsPrices.toMutableMap() // и наоборот

    fruitsPrices.forEach { (fruit, price) ->   //перебор всего словаря
        println("$fruit costs $price")
    }
    fruitsPrices.forEach {
        println("${it.key} costs ${it.value}")
    }

}

fun newFun(){

    val map1 = mapOf<String, Int>()
    for (entry in map1.entries) {
        println("${entry.key} = ${entry.value}")
    }

    println(map1.entries)
    println(map1.keys)
    println(map1.values)

    val map2 = mapOf<String, Int>()
    println(map2.getOrElse("банан"){ throw IllegalArgumentException()})
    println(map2.containsKey("банан"))
    println(map2.containsValue(10))

    val listMap2 = map2.map { "${it.key} = ${it.value}" }
    map1.isEmpty()
    map2.isNotEmpty()
    println(map2.all { it.value > 10 })
    println(map2.any {it.value > 100 })
    map2.filterValues { it > 100 }
    val map3 = map2.toMutableMap()
    map3.remove("банан")
    map3.putAll(mapOf())
    map3.clear()

}