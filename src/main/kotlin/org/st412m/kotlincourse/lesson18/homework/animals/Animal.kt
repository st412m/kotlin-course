package org.st412m.kotlincourse.lesson18.homework.animals

import org.st412m.kotlincourse.lesson18.homework.printColored

abstract class Animal() {
    abstract fun makeSound(sound: String)

    protected fun makeSound (sound: String, color: String){
        printColored("This animal makes no sound.", color)
        }
}