package org.st412m.kotlincourse.lesson18.homework

fun main() {
    val animals: List<Animal> = listOf(Dog(), Cat(), Bird())
    val sounds = listOf("Bark", "Meow", "Tweet")
    for (i in animals.indices) {
        animals[i].makeSound(sounds[i])
    }
}