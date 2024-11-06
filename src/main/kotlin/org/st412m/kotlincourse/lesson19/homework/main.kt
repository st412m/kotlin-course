package org.st412m.kotlincourse.lesson19.homework

fun main(){
    val child = ChildrenClass("значение приватного", "значение защищенного", "значение публичного")

    child.publicField = "Антонио Бандерас"
    child.updateProtectedField("Хулио Иглесиас")
    child.setPrivateField("Урмас Отт")

    println(child.getAll())

    child.printText()
}