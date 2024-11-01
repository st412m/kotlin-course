package org.st412m.kotlincourse.lesson18.homework.animals

class Bird() : Animal() {
    override fun makeSound(sound: String) {
        printColored(sound, Colors.RED)
    }
}