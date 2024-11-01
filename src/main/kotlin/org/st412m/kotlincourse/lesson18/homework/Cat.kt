package org.st412m.kotlincourse.lesson18.homework

class Cat() : Animal() {
    override fun makeSound(sound: String) {
        printColored(sound, Colors.BLUE)
    }

}