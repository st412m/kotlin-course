package org.st412m.kotlincourse.lesson31.homework.json

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

/*
Создай дата класс сотрудника компании Employee, содержащий:
имя
статус трудоустройства (булево)
дата рождения (строка)
должность CharacterTypes (enum из прошлого урока)
список подчинённых с типом Emploee

Создай небольшую иерархию из сотрудников где во главе CTO. Это значит что в объект сотрудника с должностью CTO в поле
списка подчинённых должны попасть пара тим лидов, в списке подчинённых которых есть разработчики, дизайнеры и
тестировщики. Чтобы было немного но и была вложенность.

Сериализуй CTO в текст с настройкой prettyPrinting и текст запиши в файл в корне проекта.

Прочитай текст из файла, десериализуй его в объект класса Employee и распечатай в консоль.
 */

fun main() {
    val developer1 = Employee(
        name = "Ричард Столман",
        isEmployed = true,
        birthDate = "16-03-1953",
        position = CharacterTypes.BACKEND_DEV
    )

    val developer2 = Employee(
        name = "Линус Торвальдс",
        isEmployed = true,
        birthDate = "28-12-1969",
        position = CharacterTypes.BACKEND_DEV
    )

    val designer = Employee(
        name = "Хидео Кодзима",
        isEmployed = true,
        birthDate = "24-08-1963",
        position = CharacterTypes.UX_UI
    )

    val tester = Employee(
        name = "Эдвард Деминг",
        isEmployed = true,
        birthDate = "14-10-1900",
        position = CharacterTypes.QA
    )

    val teamLead1 = Employee(
        name = "Тим Кук",
        isEmployed = true,
        birthDate = "01-11-1960",
        position = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(developer1, designer)
    )

    val teamLead2 = Employee(
        name = "Билл Гейтс",
        isEmployed = true,
        birthDate = "28-10-1955",
        position = CharacterTypes.TEAM_LEAD,
        subordinates = listOf(developer2, tester)
    )

    val cto = Employee(
        name = "Михаил Староверов",
        isEmployed = true,
        birthDate = "22-05-1977",
        position = CharacterTypes.CTO,
        subordinates = listOf(teamLead1, teamLead2)
    )
    val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    val json = gson.toJson(cto)
    val file = File("src/main/kotlin/org/st412m/kotlincourse/lesson31/homework/json/homework.json")
    file.parentFile.mkdirs()
    file.writeText(json)

    val readJson = file.readText()
    val readingCto = gson.fromJson(readJson, Employee::class.java)

    println(readingCto)

}
