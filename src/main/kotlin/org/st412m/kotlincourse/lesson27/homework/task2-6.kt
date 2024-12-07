package org.st412m.kotlincourse.lesson27.homework


fun main() {
    /*
Создайте объект Employee и используйте apply для инициализации его полей email и department.
*/
    println("\n-----Задача 2------")
    val employee1 = Employee("Иисус Христос", 33, "сын божий").apply {
        email = "jesus@heaven.com"
        department = "Eden"
    }
    println("Name: ${employee1.name}")
    println("Age: ${employee1.age}")
    println("Position: ${employee1.position}")
    println("Email: ${employee1.email}")
    println("Department: ${employee1.department}")

    println("\n-----Задача 2------")
/*
Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
Создайте объект Person и используйте also для печати данных в консоль с помощью метода который только что создали.
 */

    val person1 = Person("Адам", 30).apply {
        email = "firstman@genesis.net"
    }.also{println(niceOutput(it))}
}

fun niceOutput(obj: Person): String {
    return "Имя: ${obj.name}\nВозраст: ${obj.age}\nemail: ${obj.email}"
}

