package org.st412m.kotlincourse.lesson18.homework

class Dog() : Animal() {
     override fun makeSound(sound: String) {
         printColored(sound, Colors.PURPLE)
    }
}