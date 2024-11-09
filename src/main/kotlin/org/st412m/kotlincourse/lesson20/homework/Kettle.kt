package org.st412m.kotlincourse.lesson20.homework

class Kettle : TemperatureControlledOpeningDevice(), WaterContainer {
    override var maxTemperature: Int = 100
    override val capacity: Int = 2

    private var currentWaterLevel: Int = 0

    override fun fillWater(amount: Int) {
        if (currentWaterLevel + amount >= capacity) {
            currentWaterLevel = (currentWaterLevel + amount)
            println("Заливаем воду в чайник. Текущий уровень: $currentWaterLevel литров")
        } else {
            println("Чайник не может принять в себя столько воды")
        }
    }

    override fun getWater(amount: Int) {
        if (currentWaterLevel - amount <= 0) {
            println("Нечего выливать. Чайник пустой")
        } else {
            currentWaterLevel = (currentWaterLevel - amount)
            println("Выливаем воду из чайника. Текущий уровень: $currentWaterLevel литров")
        }
    }

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn()) {
            println("Невозможно установить температуру. Чайник выключен")
            return
        }
        super.setTemperature(temp)
    }

    override fun programAction(action: String) {
        if (!isPoweredOn()) {
            println("Невозможно запрограммировать чайник. Чайник выключен")
            return
        }
        super.programAction(action)
    }
}