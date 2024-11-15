package org.st412m.kotlincourse.lesson21

class BoxAny(private val item: Any) {
    fun getItem(): Any {
        return item
    }
}

class Box<T>(private val item: T) {  // Box будет принимать тип, который мы туда передаем, из-за <T>, соответственно
    // item будет
    // такого же типа
    fun getItem(): T {
        return item
    }
}

fun <T> printItem(item: T): T {
    println("Элемент: $item")
    return item
}

fun <T: Number> sum(a: T, b: T): Double { //Number, в данном случа ограничивает тип числовыми форматами - Int,
    // Double, Float и т.п. Т.е. стрингу сюда передать нельзя
    return a.toDouble() + b.toDouble()
}

class GenericIterator<T : Number, R : Iterable<T>>(  // T - числовой, R - интерфейс итератора(все классы которые можно
// перебирать, наследуются в том числе и от этого класса), т.е сюда мы можем передать листы, мапы и т.п.
    private val argument: T,
    private val elements: R
) {

    fun printElements() {
        for (e in elements) {
            println(
                e.toString()
                    .repeat(argument.toInt())
            )
        }
    }
}

class Container<T>(val item: T)
class PairBox<T, R>(val first: T, val second: R)
class LimitedContainer<T: Number>(val item: T?)  // можно кроме числовых объектов передать null

interface Storage<T> {
    fun setItem(item: T){
    }
    fun getItem(): T
}

interface Transformer<T, R> {
    fun transform(item: T): R
}

fun <T> swap(l: List<T>, index1: Int, index2: Int): List<T>{
    return TODO()
}

fun <T> merge(l1: List<T>, l2: List<T>): List<T> {
    return TODO()
}

fun <K, V> toMap(keys: List<K>, values: List<V>): Map<K, V> {
    return TODO()
}

fun main() {
    val appleBoxAny = BoxAny("Apple")
    val intBoxAny = BoxAny(42)

    println("В коробке: ${appleBoxAny.getItem()}") // В коробке: Apple
    println("В коробке: ${intBoxAny.getItem()}")   // В коробке: 42

    val appleBox: Box<String> = Box("Apple")
    val itemBox: Box<Int> = Box(42)

    printItem("Hello")    //функцию можно вызвать так
    printItem(1)
    printItem<String>("Hello") // или так(тип указывать необязательно)
    printItem<Int>(1)

    println(sum(5, 10))        // 15.0
    println(sum(3.5, 2.5))     // 6.0
}


