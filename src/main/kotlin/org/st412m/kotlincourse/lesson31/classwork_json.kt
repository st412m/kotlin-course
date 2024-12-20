package org.st412m.kotlincourse.lesson31

import com.google.gson.Gson
import com.google.gson.GsonBuilder

data class Address(
    val street: String,
    val city: String,
    val postalCode: Int
)
data class User(
    val id: Int,
    val name: String,
    val isActive: Boolean,
    val address: Address
)


fun main() {
    val address = Address("Baker Street", "London", 221)
    val user = User(1, "Sherlock Holmes", true, address)

    val gson = Gson() // Создаём экземпляр Gson
    val json = gson.toJson(user) // Сериализация объекта т.е. преобразовать объект в json
    println("JSON: $json")

    val user1: User = gson.fromJson(json, User::class.java) // Десериализация JSON в объект т.е. json в объект
    user1.address // после обратного преобразования можем уже работать с данными
    println("User: $user1")

    val gson1 = GsonBuilder()
        .setPrettyPrinting() // Для красивого форматирования JSON
        .serializeNulls() // Включить null-поля в JSON
        .create()

    /*
    implementation("com.google.code.gson:gson:2.10.1")  засунуть эту строку в build.gradle.kts в
    dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.code.gson:gson:2.10.1")
     */
}