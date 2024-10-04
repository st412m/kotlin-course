package org.st412m.kotlincourse.lesson9
/*
🎂 код - \uD83C\uDF82  - тортик
💐 код - \ud83d\udc90  - цветочки
🍾 код - \ud83c\udf7e  - бухлишко
💰 код - \ud83d\udcb0  - деньжата
🎁 код - \ud83c\udf81  - загадочный подарок
🎉 код - \ud83c\udf89  - всего хорошего и хорошего настроения, держитесь там
 */


fun main(){
    happyBirthday("Александр", "\ud83c\udf89")  //впиши имя и добавь подарок наверное можно и просто эмодзи
// вставить
}
fun happyBirthday(name: String, emoji: String) {
    var greeting = "С днем рождения"
    if (name.isEmpty()) {
        greeting = "$greeting!"
    } else { greeting = "$greeting, ${name}!"
    }
    var defaultEmoji = ""
    if (emoji.isEmpty()) {
        defaultEmoji = "\uD83D\uDD95"
    } else {
        defaultEmoji = emoji
    }
    var border = ""
        when {
            name.length < 7 -> {
                border = defaultEmoji.repeat((greeting.length + 4) / defaultEmoji.length)
            }

            else -> {
                border = defaultEmoji.repeat((greeting.length + 3) / defaultEmoji.length)
            }
        }
        println(border)
        println("$defaultEmoji $greeting $defaultEmoji")
        println(border)
}





