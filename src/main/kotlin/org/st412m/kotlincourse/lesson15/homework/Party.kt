package org.st412m.kotlincourse.lesson15.homework
/*
Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и
attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
 */

class Party (
    val location: String,
    var attendees: Int
) {
    fun details() {
        println("Вечеринка будет проходить по адресу: $location, приглашены $attendees гостей")
    }
}