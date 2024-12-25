package org.st412m.kotlincourse.lesson32.homework
/*
Необходимо создать класс `PhoneNumberFormatter`, который будет иметь метод `formatPhoneNumber(input: String): String`.
Этот метод должен преобразовывать входящие строки в стандартизированный формат номера телефона +7 (XXX) XXX-XX-XX.
Алгоритм преобразования следующий:

Очищаем строку от невалидных символов через замену всех нечисловых знаков на пустую строку.
Делается это через replace который принимает regex выражение "\\D".toRegex() ( \\D - это выражение,
которое находит все нечисловые значения)
Если длина полученной числовой строки не равна 10 или 11 знакам - выкидываем исключение
Если в строке 10 значений, добавляем в начало 7
Если строка начинается на `8` или `7`, символ заменяется на `+7`, иначе выкидываем исключение
Создаём фрагменты номера с помощью substring и вставляем их в шаблон
 */

class PhoneNumberFormatter() {

    fun formatPhoneNumber(input: String): String {

        val digits = input.replace("\\D".toRegex(), "")

        if (digits.length == 10) {
            return format("7$digits")
        }

        if (digits.length == 11 && digits[0] in listOf('7', '8')) {
            val formattedNumber = if (digits[0] == '8') {
                "7${digits.substring(1)}"
            } else {
                digits
            }
            return format(formattedNumber)
        }

        throw IllegalArgumentException("Некорректный номер")
    }

    fun format(digits: String): String {
        return "+7 (${digits.substring(1, 4)}) ${digits.substring(4, 7)}-${
            digits.substring(
                7,
                9
            )
        }-${digits.substring(9)}"
    }
}