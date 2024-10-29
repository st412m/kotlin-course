package org.st412m.kotlincourse.lesson17

open class Vehicle(
    val maxWeight: Int,
    val passengerCapacity: Int,
    val serialNumber: String
) {
    open fun startMovement() {
        println("Транспортное средство начало движение.")
    }

    open fun stopMovement() {
        println("Транспортное средство остановлено.")
    }
}

// Класс Колёсное транспортное средство, наследующийся от Транспортного средства
open class WheeledVehicle(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val wheelCount: Int
) : Vehicle(maxWeight, passengerCapacity, serialNumber)

// Класс Автомобиль, наследующийся от Колёсного транспортного средства
class Car(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    wheelCount: Int,
    val engineType: String,
    val bodyType: String
) : WheeledVehicle(maxWeight, passengerCapacity, serialNumber, wheelCount) {

    fun turnOnLights() {
        println("Габариты включены.")
    }

    fun turnOffLights() {
        println("Габариты выключены.")
    }

    fun activateTurnSignal(direction: String) {
        println("Поворотник включен: $direction")
    }

    fun activateWipers() {
        println("Стеклоочистители включены.")
    }
}

// Класс Велосипед, наследующийся от Колёсного транспортного средства
class Bicycle(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String
) : WheeledVehicle(maxWeight, passengerCapacity, serialNumber, 2) {

    fun pedal() {
        println("Педали крутятся.")
    }
}

// Класс Летательные аппараты
open class Aircraft(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val flightAltitude: Int
) : Vehicle(maxWeight, passengerCapacity, serialNumber) {

    fun increaseAltitude(amount: Int) {
        println("Высота увеличена на $amount метров.")
    }

    fun decreaseAltitude(amount: Int) {
        println("Высота уменьшена на $amount метров.")
    }
}

// Класс Самолёт, наследующийся от Летательного аппарата
class Airplane(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    flightAltitude: Int
) : Aircraft(maxWeight, passengerCapacity, serialNumber, flightAltitude)

// Класс Вертолёт, наследующийся от Летательного аппарата
class Helicopter(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    flightAltitude: Int
) : Aircraft(maxWeight, passengerCapacity, serialNumber, flightAltitude)

abstract class Materials {

    private val materials = mutableListOf<String>()

    fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterial(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class ExtractFirst(): Materials() {
    fun extract(): String {
        val extracted = extractMaterial()
        if (extracted.isEmpty()) {
            return ""
        }
        if (extracted.size == 1) {
            return extracted[0]
        }
        for (i in 1 until extracted.size) {
            addMaterial(extracted[i])
        }
        return extracted[0]
    }
}

class ExtractLast(): Materials() {
    fun extract(): String {
        val extracted = extractMaterial()
        if (extracted.isEmpty()) {
            return ""
        }
        if (extracted.size == 1) {
            return extracted[0]
        }
        for (i in 0 until extracted.size - 1) {
            addMaterial(extracted[i])
        }
        return extracted.last()
    }
}
class ExtractFirst1(): Materials() {
    fun extract(): String? {
        val extractedMaterial = extractMaterial()
        return if (extractedMaterial.isNotEmpty()) {
            extractedMaterial.first()
        } else {
            null
        }
    }
}

fun main() {
    val ordinalNumbers = listOf(
        "first", "second", "third", "fourth", "fifth",
        "sixth", "seventh", "eighth", "ninth", "tenth",
        "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth",
        "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"
    )

    val listForExtract = ExtractFirst()
    ordinalNumbers.forEach { listForExtract.addMaterial(it) }
    println(listForExtract.extract())
    listForExtract.printContainer()

}