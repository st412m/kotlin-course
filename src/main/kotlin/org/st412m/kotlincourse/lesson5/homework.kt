package org.st412m.kotlincourse.lesson5

fun main(){

    printSoundIntensity(initialSoundIntensity = 99.1, attenuationСoefficient = null)
    printFullPrice(priceCargo = null)
    dataVerification(temperature = null, humidity = null, airPressure = 735)
    dataVerification1(temperature1 = null, humidity1 = null, airPressure1 = null)
    dataVerification2(temperature2 = null, humidity2 = null, airPressure2 = 735)
}

//Контекст: Вы изучаете физическое явление затухания звука в помещении. У вас есть измеренное значение начальной
//интенсивности звука, но из-за ограничений оборудования данные о коэффициенте затухания иногда могут быть неизвестны.
//
//Задача: Рассчитать предполагаемую интенсивность звука после затухания. Интенсивность звука после затухания
//пропорциональна начальной интенсивности, умноженной на коэффициент затухания. Если коэффициент затухания неизвестен,
// использовать стандартное значение 0.5.


fun printSoundIntensity(initialSoundIntensity: Double, attenuationСoefficient: Double?){
    var soundIntensity = (initialSoundIntensity * (attenuationСoefficient ?: 0.5))
    println(soundIntensity)
}

//Контекст: Клиент оплачивает доставку груза. К стоимости доставки добавляется страховка на груз, которая составляет 0,5%
//от его стоимости. В случае, если стоимость не указана, то берётся стандартная стоимость в $50
//
//Задача: Рассчитать полную стоимость доставки.

fun printFullPrice(priceCargo: Double?) {
    var fullPrice = ((0.5 / 100) * (priceCargo ?: 50.0)) + (priceCargo ?: 50.0)
    println(fullPrice)
}

//Контекст: Вы проводите метеорологические измерения. Одним из важных показателей является атмосферное давление,
//которое должно быть зафиксировано. Лаборант приносит вам набор показателей, но по пути может что-нибудь потерять.
//
//Задача - сообщить об ошибке в случае отсутствия показаний атмосферного давления.

fun dataVerification(temperature: Int?, humidity: Int?, airPressure: Int?){
    airPressure ?: throw Exception("Ты потерял давление!")
}

fun dataVerification1(temperature1: Int?, humidity1: Int?, airPressure1: Int?){
    if (airPressure1 == null) {
        println("Ты потерял давление!")
    }
}

fun dataVerification2(temperature2: Int?, humidity2: Int?, airPressure2: Int?){
    var x = airPressure2 ?: -1
    if (x == -1) {
        println("Ты потерял давление!")
    }
}