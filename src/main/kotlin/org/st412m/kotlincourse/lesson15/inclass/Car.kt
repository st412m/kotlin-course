package org.st412m.kotlincourse.lesson15.inclass

class Car(
    private var brand: String,
    private var model: String
){
    fun  sayMyName() {
        println("I am $brand $model")
    }
    companion object {
        val carList = listOf("Audi", "Kia", "Запорожец")
    }
}