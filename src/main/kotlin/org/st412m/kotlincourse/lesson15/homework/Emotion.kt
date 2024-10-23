package org.st412m.kotlincourse.lesson15.homework

/*
Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String)
и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.
 */

class Emotion(
    val type: String,
    var intensity: Int ) {
        fun express() {
            val intensityDescription = when (intensity) {
                in 1..3 -> "слабая"
                in 4..6 -> "средняя"
                in 7..9 -> "сильная"
                10 -> "очень сильная"
                else -> "непонятная"
            }
            println("Эмоция: $type, Интенсивность: $intensityDescription")
        }
}