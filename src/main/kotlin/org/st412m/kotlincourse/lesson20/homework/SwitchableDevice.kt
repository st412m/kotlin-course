package org.st412m.kotlincourse.lesson20.homework

abstract class SwitchableDevice : Powerable {
    private var isOn = false
    override fun powerOn() {
        isOn = true
        println("Девайс включен")
    }

    override fun powerOff() {
        println("Девайс выключен")
        isOn = false
    }

    protected fun isPoweredOn(): Boolean {
        return isOn
    }
}