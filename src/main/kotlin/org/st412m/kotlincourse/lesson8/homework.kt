package org.st412m.kotlincourse.lesson8

fun main(){
    println(convert("Это невозможно выполнить за один день."))
    println(convert("Я не уверен в успехе этого проекта."))
    println(convert("Произошла катастрофа на сервере."))
    println(convert("Этот код работает без проблем."))
    println(convert("Удача"))
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
    val phrase = phrase.trim('.')
    return when{
        phrase.contains("невозможно", true) -> phrase.replace("невозможно", "совершенно точно возможно, просто требует времени")
        phrase.startsWith("Я не уверен", true) -> "$phrase, но моя интуиция говорит об обратном."
        phrase.contains("катастрофа", true) -> phrase.replace("катастрофа", "интересное событие.")
        phrase.endsWith("без проблем",true) -> phrase.replace("без проблем", "с парой интересных вызовов по пути.")
        !phrase.contains(" ") -> "Иногда, ${phrase.lowercase()}, но не всегда."
        else -> ""
    }
}
//Задание 1: Извлечение Даты из Строки Лога. Используй indexOf или split для получения правой части сообщения.
//Описание: У вас есть строка лога вида "Пользователь вошел в систему -> 2021-12-01 09:48:23". Извлеките отдельно дату
//и время из этой строки и сразу распечатай их по очереди.

//Задание 2: Маскирование Личных Данных
//Описание: Дана строка с номером кредитной карты "4539 1488 0343 6467". Замаскируйте все цифры, кроме последних четырех, символами "*".

//Задание 3: Форматирование Адреса Электронной Почты. Используй replace
//Описание: У вас есть электронный адрес "username@example.com". Преобразуйте его в строку "username [at] example [dot] com".

//Задание 4: Извлечение Имени Файла из Пути
//Описание: Дан путь к файлу "C:/Пользователи/Документы/report.txt". Извлеките название файла с расширением.

//Задание 5: Создание Аббревиатуры из Фразы. Используй split с набором символов для разделения. Используй for для перебора
//слов. Используй var переменную для накопления первых букв.
//Описание: У вас есть фраза, например "Объектно-ориентированное программирование". Создайте аббревиатуру из начальных
//букв слов (например, "ООП").


//Дополнительные задания
//Написать метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается с заглавной буквы а
//все остальные - строчные. (можно использовать такой же подход как в задании 5, но накапливать не первые буквы а целиком
//слова, составленные из первой буквы с uppercase и оставшейся части слова)

//Написать шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой: Kotlin
//шифруется в oKltni. Дешифровка выполняется аналогично. Если длина строки - нечётная, в конец добавляется символ пробела
//до начала шифрования. Таким образом все шифрованные сообщения будут с чётной длинной. Должно получиться два публичных
//метода: encrypt() и decrypt() которые принимают и возвращают строку.

//Вывести таблицу умножения в консоль так, чтобы были ровные строки и столбцы. В заголовках столбцов и строк -
//числа для перемножения. В перекрестии - результат умножения. Каждый столбец должен быть выровнен по правому краю.
//Для печати результата в той же строке использовать print()
//Для перехода на следующую строку использовать println()
//Для выравнивания использовать функции форматирования строк с шаблоном (%s)

//Для усложнения задачи, можно в метод передавать размерность таблицы по вертикали и горизонтали и динамически
//рассчитывать количество пробелов для форматирования.
