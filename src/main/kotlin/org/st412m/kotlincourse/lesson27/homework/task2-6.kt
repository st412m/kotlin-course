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

    println("\n-----Задача 3------")
    /*
    Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
    Создайте объект Person и используйте also для печати данных в консоль с помощью метода который только что создали.
     */

    val person1 = Person("Адам", 30).apply {
        email = "firstman@genesis.net"
    }.also { println(niceOutput(it)) }

    println("\n-----Задача 4------")
    /*
    Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee,
    указав дополнительно должность. Возвращаемым значением должен быть новый объект Employee.
     */

    val person2 = Person("Ева", 25).apply {
        email = "firstwoman@genesis.net"
    }
    val personHiring = with(person2) {
        Employee(name, age, "Посудомойка")
    }

    println("${personHiring.name}\n${personHiring.age}\n${personHiring.position}")

    println("\n-----Задача 5------")

    /*
    Создайте объект класса Person. Используйте функцию run, чтобы инициализировать объект Employee, добавить ему email
    и department с помощью apply, вернуть инициализированный объект.
     */
    val person3 = Person("Каин", 20).run {
        Employee(name, age, "Пульт от телека").apply {
            email = "firstson@genesis.net"
            department = "Счастливая семья"
        }
    }

    println("${person3.name}\n${person3.age}\n${person3.email}\n${person3.department}")

    println("\n-----Задача 6------")
    /*
    Создайте функцию, которая принимает объект класса Person?, который может быть null.
    В функции используйте функцию let для создания Employee, только если объект Person не null.
    В противном случае возвращается null
     */

    val person4: Person? = Person("Авель", 10)
    val person5: Person? = null

    forSlaughter(person4)
    println(forSlaughter(person5))

}

fun niceOutput(obj: Person): String {
    return "Имя: ${obj.name}\nВозраст: ${obj.age}\nemail: ${obj.email}"
}

fun forSlaughter(obj: Person?): Employee? {
    return obj?.let {
        Employee(it.name, it.age, "будущая жертва").apply {
            email = "firstson@genesis.net"
            department = "Счастливая семья"
        }.also {
            println("${it.name}\n${it.age}\n${it.position}\n${it.email}\n${it.department}")
        }
    }
}
