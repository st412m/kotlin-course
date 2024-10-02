package org.st412m.kotlincourse.lesson9
/*
\uD83C\uDF82  - тортик
\ud83d\udc90  - цветочки
\ud83c\udf7e  - бухлишко
\ud83d\udcb0  - деньжата
\ud83c\udf81  - загадочный подарок
\ud83c\udf89  - всего хорошего и хорошего настроения
 */


fun main(){
    happyBirthday("Александр", "\ud83c\udf89")  //впиши имя и добавь подарок наверное можно и просто эмодзи вставить
}
fun happyBirthday(name: String, emoji: String) {
    var greeting = "С днем рождения"
    if (name.isEmpty()) {
        greeting = "$greeting!"
    } else { greeting = "$greeting, ${name}!"
    }
    var border = ""
    when {name.length < 7 -> border = emoji.repeat((greeting.length + 2) / emoji.length)
        else -> border = emoji.repeat((greeting.length + 3) / emoji.length)}
    println(border)
    println("$emoji $greeting $emoji")
    println(border)
}


