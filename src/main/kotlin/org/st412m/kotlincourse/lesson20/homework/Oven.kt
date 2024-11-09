package org.st412m.kotlincourse.lesson20.homework

class Oven : TemperatureControlledOpeningDevice() {
    override var maxTemperature: Int = 250

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn()) {
            println("Не могу установить температуру. Духовка выключена")
            return
        }
        super.setTemperature(temp)
    }

    override fun programAction(action: String) {
        if (!isPoweredOn()) {
            println("Не могу установить программу. Духовка выключена")
            return
        }
        super.programAction(action)
    }
}