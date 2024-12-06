package org.st412m.kotlincourse.lesson27

fun main() {
    val list = mutableListOf(1, 2, 3, 4)
    list.add(5)
    println(list)

    val list1 = list.toList()

    val list2 = with(mutableListOf(1, 2, 3, 4)) {  // делает тоже что и выше, т.е. напрямую работает со списком,
        // который только что и создали with - специальная функция, с которой МОЖНО начинать код
        add(5)
        println(this)
        toList()
    }.size  // и соответственно имеет методы списка, но только если в конце выполнено преобразование, так как with
// (нужно провалиться в нее и что требует выводить)

    val sb = StringBuilder()
    sb.append("один")
    sb.append("два")
    sb.append("три")
    val sbLength = sb.length

    val sb1 = StringBuilder().run{ //позволяет сразу всё внутри запустить и проинициализировать
        append("один")
        append("два")
        append("три")
        length
    }

    val strList = arrayListOf<String>()
    strList.add("один")
    strList.add("два")
    strList.add("три")

    val strList1 = arrayListOf<String>().apply { //вызывается когда нужно вернуть ОДИН тот же самый тип
        add("один")
        add("два")
        add("три")
    }

    val strList2 = arrayListOf<String>().also { //вызывается когда нужно вернуть ОДИН тот же самый тип но в какой-то
        // другой ситуации
        it.add("два")
        it.add("три")
    }

    val str: String? = "длинная строка"
    str?.length
    println(str?.length)
    println(str?.isEmpty())
    println(str?.uppercase())

    str?.let {   // let позволяет выполнить код в данном случае, если str - не null
        println(it.length)
        println(it.isEmpty())
        println(it.uppercase())
    }
}