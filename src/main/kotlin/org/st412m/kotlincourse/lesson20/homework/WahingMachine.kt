package org.st412m.kotlincourse.lesson20.homework

class WashingMachine : TemperatureControlledOpeningDevice(), WaterContainer, Drainable, Timable {
    override var maxTemperature: Int = 90
    override val capacity: Int = 60

    private var currentWaterLevel: Int = 0

    override fun fillWater(amount: Int) {
        currentWaterLevel = (currentWaterLevel + amount)
        println("Заливка воды. Текущий уровень воды.: $currentWaterLevel литров")
    }

    override fun getWater(amount: Int) {
        currentWaterLevel = (currentWaterLevel - amount)
        println("Слив воды. Текущий уровень воды.: $currentWaterLevel литров")
    }

    override fun connectToDrain() {
        println("Стиральная машина подключена к сливу.")
    }

    override fun drain() {
        getWater(currentWaterLevel)
    }

    override fun setTimer(time: Int) {
        println("Таймер стирки устновлен на $time минут.")
    }

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn()) {
            println("Невозможно установить температуру. Стиралка выключена")
            return
        }
        super.setTemperature(temp)
    }

    override fun programAction(action: String) {
        if (!isPoweredOn()) {
            println("Невозможно установить программу. Стиралка выключена.")
            return
        }
        super.programAction(action)
    }
}