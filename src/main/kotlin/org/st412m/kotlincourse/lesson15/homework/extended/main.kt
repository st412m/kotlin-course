package org.st412m.kotlincourse.lesson15.homework.extended

fun main() {
    val item1 = Item("Холодильник")
    val item2 = Item("Телевизор")
    val item3 = Item("Пылесос")
    val item4 = Item("Холодильник")



    val shelf1 = Shelf(capacity = 50)

    shelf1.addItem(item1)
    shelf1.addItem(item2)
    shelf1.addItem(item3)
    shelf1.addItem(item4)
    shelf1.removeItem(item4)
    println(shelf1.info())



}