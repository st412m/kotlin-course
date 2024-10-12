package org.st412m.kotlincourse.lesson12

import org.st412m.kotlincourse.lesson4.numbers

fun main(){
    println("----Задание 1-----")
    println(funWithoutAnything())

    println("----Задание 2-----")
    println(adder(2, 2))

    println("----Задание 3-----")
    println(justString("Это просто строка"))

    println("----Задание 4-----")
    println(arithmeticMean(numbers = listOf(1, 2, 3, 4, 5)))

    println("----Задание 5-----")
    println(nullableString(null))

    println("----Задание 6-----")
    println(nullWithoutArgs())

    println("----Задание 7-----")
    println(nullList(numbers = listOf(1, 2, 3, null)))

    println("----Задание 8-----")
    println(intToNullString(1))

    println("----Задание 9-----")
    println(noArgsToNullListString())

    println("----Задание 10-----")
    println(allNull(null, null))
}

//Напишите сигнатуру функции, которая не принимает аргументов и не возвращает значения.

fun funWithoutAnything(){}

//Напишите сигнатуру функции, которая принимает два целых числа и возвращает их сумму.

fun adder(a: Int, b: Int): Int = a + b

//Напишите сигнатуру функции, которая принимает строку и ничего не возвращает.

fun justString(s: String){}

//Напишите сигнатуру функции, которая принимает список целых чисел и возвращает среднее значение типа Double.

fun arithmeticMean(numbers: List<Int>): Double {
    var sum = 0
    var counter = 0
    for (i in numbers.indices) {
        sum += numbers[i]
        counter++
    }
    return (sum / counter).toDouble()
}

//Напишите сигнатуру функции, которая принимает nullable строку и возвращает её длину в виде nullable целого числа.
fun nullableString(s: String?): Int? = s?.length

//Напишите сигнатуру функции, которая не принимает аргументов и возвращает nullable вещественное число.
fun nullWithoutArgs(): Double? {
    return null
}

//Напишите сигнатуру функции, которая принимает nullable список целых чисел и не возвращает значения.
fun nullList(numbers: List<Int?>){}

//Напишите сигнатуру функции, которая принимает целое число и возвращает nullable строку.
fun intToNullString(n: Int): String?{
    return null
}

//Напишите сигнатуру функции, которая не принимает аргументов и возвращает список nullable строк.
fun noArgsToNullListString(): List<String?>{
    return listOf("один", null, "два")
}

//Напишите сигнатуру функции, которая принимает nullable строку и nullable целое число и возвращает nullable булево
//значение.

fun allNull(s: String?, n: Int?): Boolean {
    return true
}
