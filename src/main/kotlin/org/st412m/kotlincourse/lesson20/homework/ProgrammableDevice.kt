package org.st412m.kotlincourse.lesson20.homework

abstract class ProgrammableDevice : SwitchableDevice(), Programmable {

    private val programmedActions = mutableListOf<String>()

    override fun programAction(action: String) {
        programmedActions.add(action)
    }

    override fun execute() {
        if (programmedActions.isNotEmpty()) {
            println("Выполняем программу: ${programmedActions.joinToString(", ")}")
            programmedActions.clear()
        } else {
            println("Ничего не запрограммировано")
        }
    }
}