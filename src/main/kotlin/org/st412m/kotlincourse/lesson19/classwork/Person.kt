package org.st412m.kotlincourse.lesson19.classwork

open class Person(private val name: String, protected val age: Int) {

    // Публичный метод - доступен везде
    fun greet() {
        println("Привет, меня зовут $name.")
    }

    // Защищённый метод - то же самое, что и private + видимость в субклассах;
    protected fun getName(): String {
        return name
    }

    // Приватный метод  - означает видимость только внутри этого класса (включая его члены);
    private fun secret() {
        println("Это секретный метод.")
    }
}