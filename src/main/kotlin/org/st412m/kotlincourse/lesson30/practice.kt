package org.st412m.kotlincourse.lesson30

import kotlin.jvm.Throws

enum class SeasonsOfYear(val firstMonth: String, val isVolatileDuration: Boolean) {
    WINTER("December", true),
    SPRING("March", false),
    SUMMER("June", false),
    AUTUMN("September", false);

    fun printInfo() {
        println(
            "В $this первый месяц $firstMonth ${
                if (isVolatileDuration) "сезон с изменяемой"
                else "сезон с постоянной"
            } продолжительностью"
        )
    }

    companion object {
        fun detectSeason(firstMonth: String): SeasonsOfYear {
            return entries.filter { it.firstMonth == firstMonth }.firstOrNull() ?: throw IllegalArgumentException(
                "Сезона с первым месяцем $firstMonth не существует"
            )
        }
    }
}

enum class HomeDevices(override val value: String): hasValue, hasAction {
    FRIDGE("Холодильник") {
        override fun action() {
            println("Холожу")
        }
    },
    WASHER("Стиралка") {
        override fun action() {
            println("Стираю")
        }
    },
    TV("Телевизор");

    override fun action() {
        println("Включаю $value")
    }
}



fun main() {
    SeasonsOfYear.SPRING.printInfo()
    SeasonsOfYear.WINTER.printInfo()
    println(SeasonsOfYear.detectSeason("December"))

    HomeDevices.TV.action()
    HomeDevices.WASHER.action()
    HomeDevices.FRIDGE.action()
    example(HomeDevices.TV) // такое можно провернуть, только если интерфейс имплементирован в Enum

}

fun example(arg: hasValue){
    arg.value
}
