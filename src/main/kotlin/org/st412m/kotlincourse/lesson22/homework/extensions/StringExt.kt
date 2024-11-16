package org.st412m.kotlincourse.lesson22.homework.extensions

/*
Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый символ
исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад.
Оба метода принимают один параметр base типа Int, который определяет величину сдвига. Протестируйте вашу реализацию,
убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.
*/

fun String.encrypt(shift: Int): String {
    return this.map { (it.code + shift).toChar() }.joinToString ("")
}

fun String.decrypt(shift: Int): String {
    return this.map { (it.code - shift).toChar() }.joinToString("")
}