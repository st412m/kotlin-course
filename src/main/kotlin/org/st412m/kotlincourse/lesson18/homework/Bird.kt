package org.st412m.kotlincourse.lesson18.homework

class Bird() : Animal() {
    override fun makeSound(sound: String) {
        printColored(sound, Colors.RED)
    }
}