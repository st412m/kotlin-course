package org.st412m.kotlincourse.lesson22.homework.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

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
/*
Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово только
одно, но не будем его называть). Напиши метод расширения строки, который будет принимать список имён пользователей и
выводить в консоли эту строку побуквенно в столбик: имя автора и букву под ним.
*/

fun String.pidmarkoz(users: List<String>) {
    val threadSize = this.length
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
    for (i in 0 until threadSize) {
        val horizontalBorder = "-".repeat(40)
        val dateFormatted = today.format(formatter)
        println(horizontalBorder)
        val user = users[i % users.size]
        val userAndDate = user + " ".repeat(36 - user.length - dateFormatted.length) + dateFormatted
        val charLine = this[i] + " ".repeat(36 - this[i].toString().length)
        val replies = threadSize - i - 1
        val reposts = Random.nextInt(1, users.size)
        val likes = Random.nextInt(1, users.size)
        val bookmark = Random.nextInt(1, users.size)
        val emojis = " 💬$replies     🔁$reposts     ❤️$likes     🔖$bookmark    📤"
        println("| $userAndDate |")
        println("| $charLine |")
        println("| $emojis |")
        println(horizontalBorder)
    }
}
