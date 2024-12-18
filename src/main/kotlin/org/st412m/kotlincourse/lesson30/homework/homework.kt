package org.st412m.kotlincourse.lesson30.homework
/*
Задание 1
Создай Enum со статусами прохождения теста (pass, broken, failure).
Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
 */

enum class TestStatus {
    PASS,
    BROKEN,
    FAILURE,
}

enum class PropertyTypes(val humanUnderstandable: String) {
    APARTMENT("Квартира"),
    STUDIO("Студия"),
    CONDOMINIUM("Кондоминиум"),
    TOWNHOUSE("Таунхаус"),
    DUPLEX("Дуплекс (двухквартирный дом)"),
    PENTHOUSE("Пентхаус"),
    BUNGALOW("Бунгало"),
    COTTAGE("Коттедж"),
    VILLA("Вилла"),
    MANSION("Особняк"),
    ROWHOUSE("Дом рядовой застройки"),
    LOFT("Лофт"),
    CABIN("Хижина"),
    FARMHOUSE("Фермерский дом"),
    CHALET("Шале (горный домик)"),
}

enum class Planets(val distanceToSun: Double, val weight: Double) {
    MERCURY(0.39, 3.3011e23),
    VENUS(0.72, 4.8675e24),
    EARTH(1.0, 5.9724e24),
    MARS(1.52, 6.4171e23),
    JUPITER(5.2, 1.8982e27),
    SATURN(9.58, 5.6834e26),
    URANUS(19.22, 8.6810e25),
    NEPTUNE(30.05, 1.02413e26);
}

/*
Задание 2
Cоздай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины
названия enum.
 */

fun printPropertyTypesSorted() {
    PropertyTypes.entries
        .sortedBy { it.humanUnderstandable.length }
        .forEach { println(it.humanUnderstandable) }
}


/*
Задание 3
Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum со статусом
прохождения теста в зависимости от того как выполнится принятая лямбда. Если без исключений - pass, если будет
AssertionError - failure, прочие исключения  - broken.
 */

fun evaluateTestStatus(test: () -> Unit): TestStatus {
    return try {
        test()
        TestStatus.PASS
    } catch (e: AssertionError) {
        TestStatus.FAILURE
    } catch (e: Exception) {
        TestStatus.BROKEN
    }
}

/*
Задание 4
Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать
булево значение. Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по
какому-либо признаку (расстояние или вес). Вернуть нужно первый элемент из отфильтрованного списка или выкинуть
исключение если список пустой.
 */

fun findPlanet(appropriatePlanet: (Planets) -> Boolean): Planets {
    return Planets.entries.firstOrNull(appropriatePlanet)
        ?: throw NoSuchElementException("Нет подходящих планет")
}


fun main() {
    println("\n------Задание 2--------")

    printPropertyTypesSorted()


    println("\n------Задание 3--------")

    val passTest = { println("Test passed!") }
    val failureTest = { throw AssertionError("Assertion failed!") }
    val brokenTest = { throw IllegalStateException("Unexpected error!") }

    println("Pass Test: ${evaluateTestStatus(passTest)}")
    println("Failure Test: ${evaluateTestStatus(failureTest)}")
    println("Broken Test: ${evaluateTestStatus(brokenTest)}")


    println("\n------Задание 4--------")

    val distantPlanet = findPlanet { it.distanceToSun > 8}
    println("Первая планета дальше 8 астрономических единиц от Солнца: $distantPlanet")

    val weightPlanet = findPlanet { it.weight > 2e20 }
    println("Первая планета весящая больше 2e20: $weightPlanet")

    val exceptionPlanet = findPlanet { it.weight < 1e20 && it.distanceToSun > 15 }
}