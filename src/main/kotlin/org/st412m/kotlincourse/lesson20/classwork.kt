package org.st412m.kotlincourse.lesson20

interface Device {  // интерфейс так же называют контрактом
    // Константа, определенная в companion object
    companion object {
        const val DEVICE_TYPE = "Generic Device"
    }

    // Абстрактное свойство (поле), которое должно быть переопределено в классе, реализующем интерфейс
    val deviceId: String

    // Абстрактные методы без реализации. Так же могут быть с аргументами.
    fun turnOn()
    fun turnOff()

    // Метод с реализацией, вызывающий приватный метод
    fun restart() {
        turnOff()
        logAction("Устройство с ID $deviceId выключено для перезагрузки.")
        turnOn()
        logAction("Устройство с ID $deviceId включено после перезагрузки.")
    }

    // Приватный метод с реализацией (доступно начиная с Kotlin 1.4)
    private fun logAction(action: String) {
        println("Лог действия устройства: $action")
    }
}
// канонически интерфейсы без реализации
// вызов интерфейса без круглых скобок ()
class Notebook : Device {  // можно наследоваться от множества интерфейсов, в таком случае, они указываются через
    // запятую Device, Хуяйс и так далее
    override val deviceId: String
        get() = TODO("Not yet implemented")

    override fun turnOn() {
        TODO("Not yet implemented")
    }

    override fun turnOff() {
        TODO("Not yet implemented")
    }
}
