package org.st412m.kotlincourse.lesson4

val myInt: Int = 12334535 //Int.MAX_VALUE
val myIntMax: Int = Int.MAX_VALUE
val myFloat: Float = 0.58F //Float.MIN_VALUE
val myFloatMin: Float = Float.MIN_VALUE
val myLong: Long = 1_234_234_234 //long.MAX_VALUE - принято хранить текущее время
val myLongMax: Long = Long.MAX_VALUE
val myShort: Short = -123 //Short.MIN_VALUE
val myShortMin: Short = Short.MIN_VALUE
val myByte: Byte = 12 //Byte.MAX_VALUE
val myByteMax: Byte = Byte.MAX_VALUE
val myDouble: Double = 0.0 //Double.MAX_VALUE
val myDoubleMax: Double = Double.MAX_VALUE
val myBoolean: Boolean = true
val letter: Char = 'A' //всегда одиночные кавычки, всегда должно быть значение и всегда только один символ(нельзя
// пустые кавчки)
val text: String = "Hello world" // любой длины

val numbers: Array<Int> = arrayOf(1, 2, 3)
val strings: MutableList<String> = mutableListOf("one", "two", "four")


val myIntNull: Int? = null // типы могут быть nullble добавляем "?" для обозначения

val anything: Any = false //можно вписать что угодно - строку, число и т.п.