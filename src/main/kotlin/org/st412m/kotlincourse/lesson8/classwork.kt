package org.st412m.kotlincourse.lesson8

fun main() {
    val simpleString = "простая строка"

    val firstName = "Иван"
    val lastName = "Иванов"
    val fullName = firstName + " " + lastName   //конкатенация

    val age = 30
    val greeting = "Привет! Меня зовут $firstName, и мне $age лет."  //шаблон - пример выше можно привести к шаблону
    val firstName1 = "Иван"
    val lastName1 = "Иванов"
    val fullName1 = "$firstName1 $lastName1"


    val person = Person("Алексей", 25)
    val intoduction = "Меня зовут ${person.name} и мне ${person.age}"

    //val details = "Здесь находятся ${getDetails()}"

    val x = 10
    val y = 20
    val resultString = "Результат сложения x и y  равен ${x + y}"
    println(resultString)

    val originalString = "Kotlin is fun"
    val subString = originalString.substring(7)  // выведет все с 7 символа
    val subString2 = originalString.substring(3, 6) // выведет между 3 и 6 символами (7 не включается)
    val replacedString = originalString.replace("fun", "awesome") //вырежет и заменит fun на awesome
    val words = originalString.split(" ") // делит строку на список элементов по символу в виде,по которому
// будет разделение, причем сам этот символ не входит. Выводит в список в данном случае.

    val length = "Hello".length // выводит длину строки в символах
    val upper = "hello".uppercase()  // переводит строку в верхний регистр
    val lower = "HELLO".lowercase()  // переводит строку в нижний регистр
    val trimmed = "  hello  ".trim()  //отрезает пробелы по краям строки в скобки можно передать chars которые трим
// порежет


    val starts = "Kotlin".startsWith("Kot") // выполняет проверку, начинается ли строка с определенных символов и
// возвращает True или False
    val ends = "Kotlin".endsWith("lin") // тоже самое, но проверяет конец строки
    val contains = "Hello".contains("ell") // проверяет входит ли это в строку, так же true или false

    val e: String? // или  val e: String = ""
    val empty = "  ".isNullOrEmpty()  // проверяет на Null и содержит ли данные, нужна для того чтобы если ее вызвать
// не получить NULL exeption
    val blank = "  ".isNullOrBlank()  //проверит на осмысленное содержимое

    val repeat = "ab".repeat(3)  // повторит строку 3 раза
    val letter = originalString[5]  //возмёт символ с индексом 5 из строки "Kotlin is fun", считает от 0
    val indexOfChar = "Kotlin".indexOf('t') // выведет номер инджекса буквы t, начинает считать с 0
    val indexOfWord = "Kotlin is the best language".indexOf("best") //выведет номер индекса с которого начинается "best"
    val backReverse = "niltoK".reversed() // развернет наоборот строку
    val multiLineString = """
                        Первая строка
                        Вторая строка
                        Третья строка
                   """.trimIndent()  // удалит лишние пробелы у строк, выстроенных в один ряд, если добавить пару
// пробелов, то она их оставит

    val name = "Алексей"
    val city = "Москва"
    val age1 = 32
    val friendsCount = 1052
    val rating = 4.948
    val balance = 2534.75856
    val text = """
   Имя: %s  
   Город: %s
   Возраст: %d
   Количество друзей: %,d
   Рейтинг пользователя: %.1f
   Баланс счета: $%,.2f
""".trimIndent()
    println(text.format(name, city, age1, friendsCount, rating, balance))

    println(convert("Для завершения проекта важно"))

    val text1 = "Kotlin: The Fun Way to Learn Programming"  // выводим The Fun Way
    println(text1.substring(8, 19))

    val text2 = "contact@example.com"
    val index =(text2.indexOf("@"))
    println(text2.substring(index + 1))

    val phoneNumber = "123-456-7890"
    val t = phoneNumber.split("-")
    println("xxx-xxx-${t[2]}")
}

class Person(val name: String, val age: Int)

fun convert(string: String): String{
    return when{
        string.startsWith("ошибка", true) -> string.replace("ошибка","недоразумение",true)
        string.endsWith("важно", true) -> "$string  ...Для завершения проекта важно"
        else -> ""
    }
}