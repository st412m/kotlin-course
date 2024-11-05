package org.st412m.kotlincourse.lesson19.classwork

class Atm(private var balance: Float = 0f) {
    private var pin = "123"

    fun deposit(amount: Float,pin: String) {
        checkPin(pin)
    }

    fun withdraw(amount: Float, pin: String): Float {
        checkPin(pin)
        return amount
    }

    fun getBalance(pin: String): Float{
        checkPin(pin)
        return balance
    }

    private fun checkPin(pin: String) {
        if (pin != this.pin) throw Exception("WRONG PIN")
    }
}

