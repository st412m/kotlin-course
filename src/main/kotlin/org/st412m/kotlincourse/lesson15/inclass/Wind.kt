package org.st412m.kotlincourse.lesson15.inclass

class Wind (private val speed: Int) {

    fun convert(): Int{
        return speed * 1000 / 3600
    }
}