package org.st412m.kotlincourse.lesson18.homework.animals

import org.st412m.kotlincourse.lesson18.homework.Colors
import org.st412m.kotlincourse.lesson18.homework.printColored

class Dog() : Animal() {
     override fun makeSound(sound: String) {
         printColored(sound, Colors.PURPLE)
    }
}