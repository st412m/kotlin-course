package org.st412m.kotlincourse.lesson17.homework
/*
Иерархия Мебели
Базовый класс: Мебель
Производные классы: …
Дополнительное разветвление для …: …
 */

open class Furniture(
    val material: String,
    val color: String,
    val dimensions: List<Double>,
    val weight: Double,
    val manufacturer: String
) {
    open fun getInfo(): String {
        return "Изготовлено $manufacturer из $material, габариты изделия: " +
                "${dimensions[0]}x${dimensions[1]}x${dimensions[2]} , масса " +
                "изделия $weight, цвет: $color"
    }
}

open class Tables(material: String, color: String, dimensions: List<Double>, weight: Double, manufacturer: String,
                  val type: String): Furniture(material, color, dimensions, weight, manufacturer){
}

open class Storage(material: String, color: String, dimensions: List<Double>, weight: Double, manufacturer: String,
                   val type: String): Furniture(material, color, dimensions, weight, manufacturer){
}

class foldingTable(material: String, color: String, dimensions: List<Double>, weight: Double, manufacturer: String,
                        type: String, val construction: String): Tables(material, color, dimensions, weight,
    manufacturer, type){
}

class officeStorage(material: String, color: String, dimensions: List<Double>, weight: Double, manufacturer: String,
                    type: String, val forWhat: String): Storage(material, color, dimensions, weight, manufacturer,
    type) {
}