package org.st412m.kotlincourse.lesson15.inclass

class Calculator {
    companion object {  // сразу добавляет объект к классу и к нему можно обратиться не создавая объект
        fun add(a: Int, b: Int): Int {
            return a + b
        }
    }
}
