package org.st412m.kotlincourse.lesson25

fun main() {

    val increment = fun(a: Int): Int {  // анонимная функция
        return a + 1
    }
    println(increment(1))  // её можно вызвать, обращаясь к переменной и передавая к ней аргумент. Она хранится в
// стеке и ссылается на функцию, которую мы ей назначили

    val increment1: (a: Int) -> Int = { a -> a + 1 } // это лямбда выражение, которое делает тоже что и функция. Если
// оно содержит 1 аргумент, то можно использовать it:
    val increment2: (a: Int) -> Int = {
        it + 1
    }

    val increment3 = { a: Int ->  // еще один способ записи.
        a + 1
    }


    val findIndex = fun(text: String, word: String, ignoreCase: Boolean): Int {
        return text.indexOf(word, 0, ignoreCase)
    }
    val findIndex1: (String, String, Boolean) -> Int = { text, word, ignoreCase -> // названия лучше придумывать,
        // чтобы было понятно что есть что
        text.indexOf(word, 0, ignoreCase)  // эта строка возвращает результат обязательно
    }
    val findIndex2 = { text: String, word: String, ignoreCase: Boolean ->
        text.indexOf(word, 0, ignoreCase)
    }

    println(findIndex1("I love kotlin", "kotlin", true))

}

// Обычное объявление функции
fun increment(a: Int): Int {
    return a + 1
}

fun findIndex(text: String, word: String, ignoreCase: Boolean = false): Int {
    return text.indexOf(word, 0, ignoreCase)

    val op = OrderProcessor("my address")
    op.calculateDeliveryTime(34)

}

class OrderProcessor(val deliveryAddress: String) {

    fun calculateDeliveryTime(productId: Int): String {
        val deliveryTimeDays = when (productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
    }

    val calculateDeliveryTime1 = fun OrderProcessor.(productId: Int): String { //точка означает что мы расширяем класс
        val deliveryTimeDays = when (productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
    }

    fun OrderProcessor.calculateDeliveryTime(productId: Int): String {
        val deliveryTimeDays = when (productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
    }

    val calculateDeliveryTime: OrderProcessor.(Int) -> String = {
        val deliveryTimeDays = when (it) {
            in 1..100 -> 3
            else -> 5
        }
        "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
    }
}