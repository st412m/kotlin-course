package org.st412m.kotlincourse.lesson6

//В каждом задании также нужно валидировать входящие данные, если это имеет смысл.

fun main(){
    println(seasonDefinition("июнь"))
    println(seasonDefinition1(5))
    println(agePet(5))
    println(transportType(12.5))
    println(transportType1(0.5))
    println(bonus(1500.0))
    println(docType("doc"))
    println(temperatureConversion(0,"F"))
    println(clothingSelection(-10))
    println(movieSelection(15))
}


//Задание 1: "Определение Сезона"
//Контекст: Напишите функцию, которая на основе номера месяца возвращает сезон года.// я лопух и не умею читать
// задания))

fun seasonDefinition(month: String):String {
    val winter = listOf("декабрь", "январь", "февраль")
    val spring = listOf("март", "апрель","май")
    val summer = listOf("июнь", "июль", "август")
    val autumn = listOf("сентябрь", "октябрь", "ноябрь")
    return when(month){
        in winter -> "зима"
        in spring -> "весна"
        in summer -> "лето"
        in autumn -> "осень"
        else -> "нет такого месяца"
    }
}

// на основе номера теперь

fun seasonDefinition1(month: Int):String {
    return when(month){
        in 1..2, 12 -> "зима"
        in 3..5 -> "весна"
        in 6..8 -> "лето"
        in 9..11 -> "осень"
        else -> "такого месяца не существует"
        }
}

//Задание 2: "Расчет Возраста Питомца"
//Контекст: Создайте функцию, которая преобразует возраст собаки в "человеческие" годы. До 2 лет каждый год собаки
//равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам.

fun agePet(age: Int): Double {
        return if (age in 0..2) {
            age * 10.5
        } else
            (2 * 10.5) + ((age - 2) * 4)
    }

//Задание 3: "Определение Вида Транспорта"
//Контекст: Напишите функцию, которая определяет, какой вид транспорта лучше использовать, исходя из длины маршрута.
//Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".

fun transportType(distance: Double): String {
    return if (distance < 1) {
        "пешком"
    } else if (distance in 1.0..5.0){
        "велосипед"
    }else "автотранспорт"
}

// можно через when

fun transportType1(distance: Double): String {
    return when {
    distance < 1 -> "пешком"
    distance in 1.0..5.0 -> "велосипед"
    else -> "автотранспорт"
}
}

//Задание 4: "Расчет Бонусных Баллов"
//Контекст: Клиенты интернет-магазина получают бонусные баллы за покупки. Напишите функцию, которая принимает сумму
//покупки и возвращает количество бонусных баллов: 2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и 5
//баллов за каждые 100 рублей при сумме свыше этого.

// я х.з. как округлить до целого эти ваши баллы

fun bonus(purchaseAmount: Double): Double {
    return if (purchaseAmount <= 1000) {
        (purchaseAmount / 100) * 2 // максимально 20 баллов за 1000 рублей
    }else 20 + ((purchaseAmount - 1000) / 100) * 5
}

//Задание 5: "Определение Типа Документа"
//Контекст: В системе хранения документов каждый файл имеет расширение. Напишите функцию, которая на основе расширения
//файла возвращает его тип: "Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".

fun docType(ext: String): String {
    return when(ext) {
        in "txt","doc","docx" -> "Текстовый документ"
        in "jpg","png","bmp","gif" -> "Изображение"
        in "xls","xlsx" -> "Таблица"
        else -> "Неизвестный тип"
    }
}

//Задание 6: "Конвертация Температуры"
//Контекст: Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты и наоборот в зависимости
//от указанной единицы измерения (C/F). Единицу измерения нужно передать вторым аргументом функции. Несколько аргументов
//передаются через запятую. Возвращать нужно строку.
//Подсказка: для генерации строки из числа и буквы можно использовать шаблон “$result F” для фаренгейта или “$result
// C” для цельсия

fun temperatureConversion(value: Int, unitMeasurement: String): String {
    return if (unitMeasurement == "C") {
        "${(value * 1.8) + 32} F"
    } else {
        "${(value - 32) / 1.8} C"
    }
}

//Задание 7: "Подбор Одежды по Погоде"
//Контекст: Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды: "куртка и шапка" при
//температуре ниже 0, "ветровка" от 0 до 15 градусов и "футболка и шорты" при температуре выше 15.
//При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.

fun clothingSelection(temperature: Int): String {
    return when(temperature) {
        in -30..-1 -> "куртка и шапка"
        in 0..14 -> "ветровка"
        in 15..34 -> "футболка и шорты"
        else -> "сидим дома"
    }
}

//Задание 8: "Выбор Фильма по Возрасту"
//Контекст: Кинотеатр предлагает фильмы разных возрастных категорий. Напишите функцию, которая принимает возраст зрителя и
//возвращает доступные для него категории фильмов: "детские", "подростковые", "18+".

fun movieSelection(age: Int): String {
    return when(age) {
        in 0..10 -> "детские"
        in 11..18 -> "детские, подростковые"
        else -> "детские, подростковые, 18+"
    }
}
