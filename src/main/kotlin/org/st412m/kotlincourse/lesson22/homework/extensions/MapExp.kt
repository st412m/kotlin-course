package org.st412m.kotlincourse.lesson22.homework.extensions

/*
Реализуйте функцию-расширение для класса словаря допускающего null с ключами дженериком и значениями типа список из
такого же дженерика, которая принимает один аргумент типа число и возвращает словарь допускающий null с ключами типа
строка и значениями типа дженерика допускающего null.
 */

fun <T> Map<T, List<T>>?.returnMapGenericNull(arg: Number): Map<String, T?>? {
    if (this == null) return null
    val result = mutableMapOf<String, T?>()
    for ((k, v) in this)
    if (arg in v.indices) {
        val value = v[arg.toInt()]
        result[k.toString()] = value
    } else {
        val value: T? = null
        result[k.toString()] = value
    }
    return result
}
