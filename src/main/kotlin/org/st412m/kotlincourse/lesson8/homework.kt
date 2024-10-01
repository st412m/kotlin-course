package org.st412m.kotlincourse.lesson8

fun main(){
    println("---задача 0-----")
    println(convert("Это невозможно выполнить за один день."))
    println(convert("Я не уверен в успехе этого проекта."))
    println(convert("Произошла катастрофа на сервере."))
    println(convert("Этот код работает без проблем."))
    println(convert("Удача"))
    println("---задача 1-----")
    dateTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    println("---задача 2-----")
    creditCard("4539 1488 0343 6467")
    println("---задача 3-----")
    emailFormat("username@example.com")
    println("---задача 4-----")
    filePath("C:/Пользователи/Документы/report.txt")
    println("---задача 5-----")
    println(abbreviation("Объектно-ориентированное программирование"))
    println("---доп.задача 1-----")
    println(upperChars("Муля не нервируй меня"))
    println(upperChars1("Муля не нервируй меня"))
    println("---доп.задача 2-----")
    println(encrypt("Kotlin"))
    println(decrypt("oKltni"))
    println("---доп.задача 3-----")
    multiplicationTable(-8, 12)


}
//Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования, делая текст
//более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.
//Правила Проверки и Преобразования:
//Если фраза содержит слово "невозможно":
//Преобразование: Замените "невозможно" на "совершенно точно возможно, просто требует времени".
//Если фраза начинается с "Я не уверен":
//Преобразование: Добавьте в конец фразы ", но моя интуиция говорит об обратном".
//Если фраза содержит слово "катастрофа":
//Преобразование: Замените "катастрофа" на "интересное событие".
//Если фраза заканчивается на "без проблем":
//Преобразование: Замените "без проблем" на "с парой интересных вызовов на пути".
//Если фраза содержит только одно слово:
//Преобразование: Добавьте перед словом "Иногда," и после слова ", но не всегда".
//Примеры Тестовых Фраз:
//"Это невозможно выполнить за один день."
//"Я не уверен в успехе этого проекта."
//"Произошла катастрофа на сервере."
//"Этот код работает без проблем."
//"Удача"

fun convert(phrase: String): String{
    return when{
        phrase.contains("невозможно", true) -> phrase.replace("невозможно", "совершенно точно возможно, просто требует времени")
        phrase.startsWith("Я не уверен", true) -> "${phrase.trim('.')}, но моя интуиция говорит об обратном."
        phrase.contains("катастрофа", true) -> phrase.replace("катастрофа", "интересное событие")
        phrase.endsWith("без проблем.",true) -> phrase.replace("без проблем", "с парой интересных вызовов по пути")
        !phrase.contains(" ") -> "Иногда, ${phrase.lowercase()}, но не всегда"
        else -> ""
    }
}
//Задание 1: Извлечение Даты из Строки Лога. Используй indexOf или split для получения правой части сообщения.
//Описание: У вас есть строка лога вида "Пользователь вошел в систему -> 2021-12-01 09:48:23". Извлеките отдельно дату
//и время из этой строки и сразу распечатай их по очереди.

fun dateTime(login: String) {
    val t = login.split(" ")
    return println("${t[5]}\n${t[6]}")
}

//Задание 2: Маскирование Личных Данных
//Описание: Дана строка с номером кредитной карты "4539 1488 0343 6467". Замаскируйте все цифры, кроме последних четырех, символами "*".
fun creditCard(number: String) {
    val splitNumber = number.split(" ")
    return println("**** **** **** ${splitNumber[3]}")
}

//Задание 3: Форматирование Адреса Электронной Почты. Используй replace
//Описание: У вас есть электронный адрес "username@example.com". Преобразуйте его в строку "username [at] example [dot] com".
fun emailFormat(email: String) {
    val newEmail = email.replace("@", " [at] ").replace(".", " [dot] ")
    return println(newEmail)
}

//Задание 4: Извлечение Имени Файла из Пути
//Описание: Дан путь к файлу "C:/Пользователи/Документы/report.txt". Извлеките название файла с расширением.
fun filePath(path: String){
    val splitPath = path.split("/")
    return println(splitPath.last())
}

//Задание 5: Создание Аббревиатуры из Фразы. Используй split с набором символов для разделения. Используй for для перебора
//слов. Используй var переменную для накопления первых букв.
//Описание: У вас есть фраза, например "Объектно-ориентированное программирование". Создайте аббревиатуру из начальных
//букв слов (например, "ООП").

fun abbreviation(phrase1: String): String {
    val abbrList = phrase1.split(' ', '-')
    var abbrPhrase = ""
    for (j in abbrList.indices) { //for (i in 0 until abbrList.length)
        abbrPhrase += (abbrList[j][0].uppercase())
    }
    return abbrPhrase
}

//Дополнительные задания
//Написать метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается с заглавной буквы а
//все остальные - строчные. (можно использовать такой же подход как в задании 5, но накапливать не первые буквы а целиком
//слова, составленные из первой буквы с uppercase и оставшейся части слова)

fun upperChars(phrase2: String): String {
    val splitPhase = phrase2.split(" ")
    var capitalPhrase2 = ""
    for (j in splitPhase.indices) {
        capitalPhrase2 +=  ("${splitPhase[j].replaceFirstChar(Char::uppercase)} ")
    }
    return capitalPhrase2.trim()
}

fun upperChars1(phrase2: String): String {
    val splitPhrase = phrase2.split(" ")
    var capitalPhrase2 = ""
    for (j in splitPhrase) {
        capitalPhrase2 += j[0].uppercase() + j.substring(1) + " "
    }
    return capitalPhrase2.trim()
}


//Написать шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой: Kotlin
//шифруется в oKltni. Дешифровка выполняется аналогично. Если длина строки - нечётная, в конец добавляется символ пробела
//до начала шифрования. Таким образом все шифрованные сообщения будут с чётной длинной. Должно получиться два публичных
//метода: encrypt() и decrypt() которые принимают и возвращают строку.

fun encrypt(cipher: String): String{
    var forCrypt = cipher
    if(cipher.length % 2 !=0){
        forCrypt += " "
    }else {
        Unit
    }
    var encrypted = ""
    for(i in forCrypt.indices step 2){
        val symbol1 = forCrypt[i]
        val symbol2 = forCrypt[i + 1]
        encrypted += symbol2.toString() + symbol1.toString()
    }
    return encrypted
}

fun decrypt(cipher: String): String{
    var decrypted = ""
    for(i in cipher.indices step 2){
        val symbol1 = cipher[i]
        val symbol2 = cipher[i + 1]
        decrypted += symbol2.toString() + symbol1.toString()
    }
    return decrypted
}

//Вывести таблицу умножения в консоль так, чтобы были ровные строки и столбцы. В заголовках столбцов и строк -
//числа для перемножения. В перекрестии - результат умножения. Каждый столбец должен быть выровнен по правому краю.
//Для печати результата в той же строке использовать print()
//Для перехода на следующую строку использовать println()
//Для выравнивания использовать функции форматирования строк с шаблоном (%s)

//Для усложнения задачи, можно в метод передавать размерность таблицы по вертикали и горизонтали и динамически
//рассчитывать количество пробелов для форматирования.

fun multiplicationTable(column: Int, line:Int){
    val lineWidth = ((line * column).toString()).length  // ищем самое длинное число с точки зрения символов
    print(" ".repeat(lineWidth + 1)) // Пустое место в начале
    if (line > 0){
        for(i in 1..line) {
            print(" %${lineWidth + 1}s".format(i))
        }
    } else if (line < 0) {
        for (i in -1 downTo line) {
            print(" %${lineWidth + 1}s".format(i))
        }
    }
    println()
    if (column > 0) {
        for (i in 1..column) {
            print("%${lineWidth + 1}s".format(i))
            if (line > 0) {
                for (z in 1..line) {
                    val result = (i * z).toString()
                    print(" %${lineWidth + 1}s".format(result))
                }
            } else if (line < 0) {
                for (z in -1 downTo line) {
                    val result = (i * z).toString()
                    print(" %${lineWidth + 1}s".format(result))
                }
            }
            println()
        }
    } else if (column < 0) {
        for (i in -1 downTo column) {
            print("%${lineWidth + 1}s".format(i))
            if (line > 0) {
                for (z in 1..line) {
                    val result = (i * z).toString()
                    print(" %${lineWidth + 1}s".format(result))
                }
            } else if (line < 0) {
                for (z in -1 downTo line) {
                    val result = (i * z).toString()
                    print(" %${lineWidth + 1}s".format(result))
                }
            }
            println()
        }
    }
}