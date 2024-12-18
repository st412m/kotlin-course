package org.st412m.kotlincourse.lesson30.homework

/*
Создай enum с перечислением для светофора. Enum должен включать цвет из класса Colors, длительность сигнала duration и
количество миганий blinkTimes (может быть null). Мигание нужно установить только для зелёного сигнала.
Реализовать функцию с бесконечным циклом, которая будет выводить сигналы светофора в порядке:
красный (4 сек), жёлтый (2 сек), зелёный (4 сек), зелёный мигающий (4 раза).
Отображение сигнала выполняется через showSignal()
Задержку между сигналами можно выполнить через Thread.sleep() в который передаётся задержка в миллисекундах.
Мигание выполняется через попеременный вызов clear() и showSignal() с задержками между ними в 300мс
 */

enum class TrafficLightSignal(val color: Colors, val duration: Int, val blinkTimes: Int?){
    RED(Colors.RED_COLOR, 4, null),
    YELLOW(Colors.YELLOW_COLOR, 2, null),
    GREEN(Colors.GREEN_COLOR, 4, 4),
}

enum class Colors(val value: String) {
    RED_COLOR("\u001B[31m"),
    YELLOW_COLOR("\u001B[33m"),
    GREEN_COLOR("\u001B[32m"),
    RESET_COLOR("\u001B[0m")
}
const val LIGHT_SYMBOL = "\u25CF"
// Функция для отображения сигнала
fun showSignal(signal: TrafficLightSignal) {
    print("\r" + signal.color.value + LIGHT_SYMBOL + Colors.RESET_COLOR.value) // Выводим сигнал с возвратом каретки
}
fun clear() {
    print("\r    ")
}

fun trafficLightLoop() {
    while (true) {
        TrafficLightSignal.entries.forEach { signal ->
            showSignal(signal)
            Thread.sleep(signal.duration * 1000L)

            signal.blinkTimes?.let { times ->
                repeat(times) {
                    clear()
                    Thread.sleep(300)
                    showSignal(signal)
                    Thread.sleep(300)
                }
            }
        }
    }
}

fun main() {
    trafficLightLoop()
}
