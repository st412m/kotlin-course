package org.st412m.kotlincourse.lesson20

abstract class HouseholdAppliance(val brand: String) {

    abstract val applianceType: String

    var isPoweredOn: Boolean = false
        private set

    abstract fun operate()

    fun powerOn() {
        isPoweredOn = true
        println("$applianceType от $brand включено.")
        onPowerChange()
    }

    fun powerOff() {
        isPoweredOn = false
        println("$applianceType от $brand выключено.")
        onPowerChange()
    }

    private fun onPowerChange() {
        if (isPoweredOn) {
            println("Устройство готово к работе.")
        } else {
            println("Устройство выключено.")
        }
    }


    protected open fun performMaintenance() {
        println("Выполняется обслуживание $applianceType от $brand.")
    }
}

class Microwave(brand: String) : HouseholdAppliance(brand) {
    override val applianceType: String = "Микроволновая печь"

    override fun operate() {
        if (isPoweredOn) {
            println("Готовим еду в микроволновке от $brand.")
            performMaintenance()
        } else {
            println("Микроволновая печь от $brand не включена. Пожалуйста, включите ее.")
        }
    }

    override fun performMaintenance() {
        super.performMaintenance()
        println("Чистка микроволновой печи от $brand.")
    }
}
fun main() {
    val microwave = Microwave("Sony")
    microwave.powerOn()
    microwave.operate()
}