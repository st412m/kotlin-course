package org.st412m.kotlincourse.lesson15.inclass

class Lamp(
    private var isLight: Boolean
) {
    fun switch(){
        isLight = !isLight
        println(isLight)
    }
}