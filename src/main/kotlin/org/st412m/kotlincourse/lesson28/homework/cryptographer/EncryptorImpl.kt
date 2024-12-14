package org.st412m.kotlincourse.lesson28.homework.cryptographer

class EncryptorImpl : Encryptor {
    override fun encrypt(content: String): String {
        val shift = 3
        return content.map { char ->
            (char + shift).toChar()
        }.joinToString("")
    }
}