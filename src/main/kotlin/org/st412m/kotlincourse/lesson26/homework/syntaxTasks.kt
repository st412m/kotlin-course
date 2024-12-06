package org.st412m.kotlincourse.lesson26.homework

/*
Напишите функцию, которая принимает другую функцию без аргументов и возвращаемого значения.
 */

fun func1(
    withoutAnything: () -> Unit,
) {
}

/*
Создайте функцию, принимающую функцию с одним аргументом типа Int и возвращающую String.
 */

fun func2(
    singleArg: (Int) -> String,
) {
}

/*
Реализуйте функцию, принимающую функцию расширения типа Int, принимающую String и возвращающую Boolean.
 */

fun func3(
    intExtension: Int.(String) -> Boolean,
) {
}

/*
Напишите функцию, которая принимает функцию с двумя аргументами типа Double и возвращает Boolean.
 */

fun func4(
    twoArg: (Double, Double) -> Boolean,
) {
}

/*
Напишите функцию, которая принимает функцию с одним аргументом-дженериком T и возвращает List<T>.
 */

fun <T> func5(
    oneGeneric: (T) -> List<T>,
) {
}

/*
Создайте функцию, принимающую функцию с аргументом типа String и возвращающую другую функцию, принимающую Int
и возвращающую Boolean.
 */

fun func6(
    returnFunc: (String) -> ((Int) -> Boolean),
) {
}

/*
Напишите функцию, которая принимает список чисел, множество строк, функцию с аргументами типа List<Int> и Set<String>
и возвращающую Map<String, Int>.
 */

fun func7(
    list: List<Number>,
    set: Set<String>,
    strangeFunc: ((List<Int>, Set<String>) -> Unit) -> Map<String, Int>,
) {
}

/*
Напишите функцию, возвращающую строку, принимающую число и функцию, принимающую число и возвращающую строку
 */

fun func8(
    num: Number,
    returnString: ((Number) -> String) -> String,
): String {
    return num.toString()
}

/*
Напишите функцию, принимающую функцию, которая возвращает функцию без аргументов и возвращаемого значения.
 */

fun func9(
    funFun: (() -> () -> Unit) -> Unit,
) {
}
