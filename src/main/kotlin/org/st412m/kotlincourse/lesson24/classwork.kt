package org.st412m.kotlincourse.lesson24

import java.io.File

fun main(){
    /*
    try {
        val  x = listOf(1)
        x[2] // пропустит первый блок catch и перейдет ко второму
        val  r = null
        r!!   // говорим что r не null и застрянем в первом блоке catch

    } catch (e: NullPointerException) {
        println("NullPointerException")
        // Обработка конкретного типа исключения
    } catch (e: RuntimeException) {
        println("RuntimeException")
        // Обработка всех остальных исключений
    } finally {
        println("Последний блок")  // выведется в любом случае не важно были исключения или нет
    }

    try {
        // Код, который может выбросить исключения
    } catch (e: Exception) {
        when(e) {
            is Exception, is NullPointerException -> {
                // Обработка исключений ExceptionA или ExceptionB
                println("Обработано исключение типа A или B")
            }
            else -> throw e // Перебрасываем исключение дальше, если оно не соответствует обработанным типам
        }
    }
*/
    try {
        val a = "строка" as Double
    } catch (e: ClassCastException) {
        println("это не может быть преобразовано в Double")
    }

//    setAge(-1)

//    val file = File("testfile")
//    file.createNewFile()
//    val i = file.inputStream()
//    i.close()
//    i.read()

    val list = mutableListOf("")
    try {
        while (true) {
            list.add("данные")
        }
    } catch (e: Throwable){
        println("Памяти пиздец")
    }
}


fun setAge(age: Int){
//    require(age >= 0){"Возраст не может быть отрицательным"} //встроенная функция которая должна проверить
    //    аргументы на валидность
    check(age >= 0){"Возраст не может быть отрицательным"} //встроенная функция проверяющая состояние объектов
}