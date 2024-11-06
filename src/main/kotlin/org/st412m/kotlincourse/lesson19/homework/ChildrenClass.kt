package org.st412m.kotlincourse.lesson19.homework

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    /*
    объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    потому что он в BaseClass объявлен как val publicVal: String - т.е. публичный по умолчанию. А ChildrenClass
    наследует от BaseClass
    */
    publicVal: String


) : BaseClass(privateVal, protectedVal, privateVal) {

    /*
    объясни, почему в main() доступна функция getAll() хотя её здесь нет
    потому что этот класс наследует от BaseClass, где эта функция публичная и передается вообще всем
     */

    // проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun verifyPublicField(value: String): Boolean {
        return true
    }

    fun updateProtectedField(value: String) {
        protectedField = value
    }

}