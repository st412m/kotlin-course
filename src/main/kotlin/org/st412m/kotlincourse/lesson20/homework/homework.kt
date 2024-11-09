package org.st412m.kotlincourse.lesson20.homework

fun main() {

    val fridge = FridgeDevice()
    val washingMachine = WashingMachine()
    val kettle = Kettle()
    val oven = Oven()

    println("----Холодильник----")
    fridge.setTemperature(5)
    fridge.powerOn()
    fridge.setTemperature(5)
    fridge.programAction("Охлаждение на 2 часа")
    fridge.execute()
    fridge.powerOff()

    println("----Стиральная машина-----")
    washingMachine.fillWater(30)
    washingMachine.setTemperature(40)
    washingMachine.powerOn()
    washingMachine.setTemperature(40)
    washingMachine.setTimer(60)
    washingMachine.programAction("Стирка штанов")
    washingMachine.execute()
    washingMachine.drain()
    washingMachine.powerOff()

    println("----Чайник----")
    kettle.fillWater(1)
    kettle.setTemperature(90)
    kettle.powerOn()
    kettle.setTemperature(90)
    kettle.programAction("Кипячение воды")
    kettle.execute()
    kettle.getWater(0.5.toInt())
    kettle.powerOff()


    println("----Духовка-----")
    oven.setTemperature(180)
    oven.powerOn()
    oven.setTemperature(180)
    oven.programAction("Запекаем лазанью")
    oven.execute()
    oven.powerOff()
}