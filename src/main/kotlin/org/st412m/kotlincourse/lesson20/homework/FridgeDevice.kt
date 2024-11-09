package org.st412m.kotlincourse.lesson20.homework

class FridgeDevice : TemperatureControlledOpeningDevice() {
    override var maxTemperature: Int = 8 // Максимальная температура для холодильника

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn()) {
            println("Не могу установить температуру. Холодильник выключен")
            return
        }
        super.setTemperature(temp)
    }

    override fun programAction(action: String) {
        if (!isPoweredOn()) {
            println("Не могу запрограммировать. Холодильник выключен.")
            return
        }
        super.programAction(action)
    }
}