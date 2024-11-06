package org.st412m.kotlincourse.lesson19.homework

abstract class BaseClass(
    /*
    объясни, почему это поле доступно в main() для чтения из класса ChildrenClass:
    потому что в ChildrenClass оно сохраняется как public
     */
    private val privateVal: String,

    /*
    объясни, почему это поле недоступно в main()
    потому что оно имеет модификатор protected, который ограничивает доступ только к BaseClass и его наследникам
    */
    protected val protectedVal: String,
    val publicVal: String
) {

    var publicField = "измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }

    protected var protectedField = "измени меня из функции main() через сеттер в наследнике"
    private var privateField = "добавь сеттер чтобы изменить меня из main()"
    fun setPrivateField(value: String) {
        privateField = value
    }


    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    /*
    объясни, почему эта функция не может быть публичной
    потому что она возвращает ProtectedClass, который объявлен как protected, а он может быть доступен только в
    классе или субклассах. Т.е. она должна быть protected, чтобы соответствовать уровню ProtectedClass
     */
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    /*
    объясни, почему эта функция не может быть публичной или protected
    по той же причине, что и выше, она возвращает PrivateClass, который объявлен как privat, а он может быть доступен
    только внутри класса. Если сделать public или protected, то этот класс будет доступен снаружи, что нарушает
    правила инкапсуляции.
     */
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass

    private class PrivateClass
}

