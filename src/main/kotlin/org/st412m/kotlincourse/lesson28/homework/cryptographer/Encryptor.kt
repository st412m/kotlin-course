package org.st412m.kotlincourse.lesson28.homework.cryptographer

interface Encryptor {
    fun encrypt(content: String): String
}