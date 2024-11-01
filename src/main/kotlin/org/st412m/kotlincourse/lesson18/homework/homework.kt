package org.st412m.kotlincourse.lesson18.homework

import org.st412m.kotlincourse.lesson18.homework.animals.Animal
import org.st412m.kotlincourse.lesson18.homework.animals.Bird
import org.st412m.kotlincourse.lesson18.homework.animals.Cat
import org.st412m.kotlincourse.lesson18.homework.animals.Dog
import org.st412m.kotlincourse.lesson18.homework.printer.InkjetPrinter
import org.st412m.kotlincourse.lesson18.homework.printer.LaserPrinter
import org.st412m.kotlincourse.lesson18.homework.shapes.Circle
import org.st412m.kotlincourse.lesson18.homework.shapes.Shape
import org.st412m.kotlincourse.lesson18.homework.shapes.Square
import org.st412m.kotlincourse.lesson18.homework.shapes.Triangle

fun main() {
    val animals: List<Animal> = listOf(Dog(), Cat(), Bird())
    val sounds = listOf("Bark", "Meow", "Tweet")
    for (i in animals.indices) {
        animals[i].makeSound(sounds[i])
    }

    val figures: List<Shape> = listOf(Square(11.0), Circle(10.0), Triangle(5.0, 3.0, 4.0))
    figures.forEach { figure ->
        println(figure.figureArea())
    }

    val text = "Ojcze nasz, któryś jest w niebie, święć się imię Twoje" +
            "przyjdź królestwo Twoje" +
            "bądź wola Twoja jako w niebie tak i na ziemi" +
            "chleba naszego powszedniego daj nam dzisiaj;" +
            "i odpuść nam nasze winy, jako i my odpuszczamy naszym winowajcom" +
            "i nie wódź nas na pokuszenie" +
            "ale nas zbaw ode Złego" +
            "Amen."
    println("-----Лазерник------")
    val laserPrinter = LaserPrinter()
    laserPrinter.print(text)
    println("-----Струйник------")
    val inkjetPrinter = InkjetPrinter()
    inkjetPrinter.print(text)
}