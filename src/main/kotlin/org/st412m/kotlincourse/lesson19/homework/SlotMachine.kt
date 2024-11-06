package org.st412m.kotlincourse.lesson19.homework
/*
Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов
(аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)

Поля:
цвет
модель
включен
ОС загружена
список доступных игр
наличие джойстика
баланс вырученных средств
владелец
телефон поддержки.

Методы:
включить
выключить
загрузить ОС
завершить работу ОС
показать список игр
включить игру
оплатить игровой сеанс
открыть сейф и выдать наличные
выплатить выигрыш
 */

class SlotMachine(
    val color: String,
    val model: String,
    private var isOn: Boolean = false,
    private var isOSLoaded: Boolean = false,
    private val availableGames: List<String>,
    val hasJoystick: Boolean,
    private var balance: Double = 0.0,
    val owner: String,
    val supportPhone: String
) {

    fun powerOn() {
        isOn = true
    }

    fun powerOff() {
        isOn = false
    }

    private fun loadOS() {

    }

    private fun shutdownOS() {

    }

    fun showGames(): List<String> {
        return availableGames
    }

    fun startGame(gameName: String): Boolean {
        return availableGames.contains(gameName)
    }

    fun payForSession(amount: Double) {
        balance += amount
    }

    private fun openSafeAndDispenseCash(amount: Double): Boolean {
        return if (balance >= amount) {
            balance -= amount
            true
        } else {
            false
        }
    }

    private fun payoutWinnings(amount: Double): Boolean {
        return openSafeAndDispenseCash(amount)  // по идее здесь должен быть еще один метод типа youWin, который и
    // будет обращаться к этому приватному методу.
    }
}