package org.st412m.kotlincourse.lesson7

fun main() {
    for (item in listOf(1,2,3,4,5,6)) {    //listof() - это просто пример коллекции, могут быть диапазоны и т.п. item
    // можно сократить до i
        // тело цикла
    }
    for (i in 1..10) {
        println(i)
    }
    for (i in 10 downTo 1 step 2){ // step 2 - шаг с которым происходит вычисление
        println(i)
    }
    var range = 1..10
    for (i in range) {
        println(i)
    }
    var counter = 10
    while (counter-- >0) {   // пока счетчик больше 0, начинает отчет с 9, так как декремент сразу выполняется, если
        // декремента нет то будет бесконечный цикл, если предекремент --counter, то отсчет закончится на 1, а не на
        // 0 - нихрена не понял - ОБДУМАТЬ
        println(counter)
    }
    do{
        println("*")  // сначала обязательно выполняет один проход цикла используется для сокращения кода
    } while (false)
    for (i in 1..10){
        if (i==2) continue    //продолжает цикл
        if (i==7) break       //прерывает цикл
        println(i)
    }
// ------------------------------------------------------------------------------------------------------------------
    for (item in 1..5){
        println(item*item)
    }

    for (item in 10 downTo 1)
        println(item)

    for (item in 20 downTo 1){
        if (item % 2 == 0) {
            println(item)
        }
    }

    for (item in 1..30 step 3){
        println(item)
    }

    var count = 1
    var sum = 0
    while (count <= 10) {
        sum += count++
    }

    var counter1 = 100
    while (counter1-- >1) {
        println(counter--.toString().length)
    }
}

