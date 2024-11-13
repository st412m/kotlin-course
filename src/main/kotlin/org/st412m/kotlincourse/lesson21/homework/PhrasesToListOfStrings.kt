package org.st412m.kotlincourse.lesson21.homework
/*
Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
 */

class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun transform(element: String): List<String> {
        return element.split(" ")
    }

    override fun transformList(elementList: List<String>): List<List<String>> {
        return elementList.map { it.split(" ") }
    }
}