package org.st412m.kotlincourse.lesson15.inclass

fun main() {
    val person = Person("John", 30)
    person.sayHello()

    Logger.log("123")

    val result = Calculator.add(5, 3)
    println("Result: $result")

    val user1 = User(1, "Alice")
    val user2 = user1.copy(name = "Bob")

    println(user1) // только data class выводится в виде User(id=1, name=Alice) остальные классы выводятся в
    // котлинском представлении
    println(user2)

    val lamp1 = Lamp(true)
    lamp1.switch()

    val wind = Wind(10)
    println(wind.convert())

    val car1 = Car(Car.carList[1], "m5")
    car1.sayMyName()
}