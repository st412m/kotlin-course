package org.st412m.kotlincourse.lesson32

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class TextToPhoneTest {

    @ParameterizedTest
    @MethodSource("providePhoneNumber")
    fun `check convertation`(
        phoneNumber: String,
        expected: String
    ) {
        val actual = textToPhone(phoneNumber)
        assertEquals(expected, actual)
    }

    //добавить негативные тесты -- недостаточное количество, другие цифры в начале
    //сделать разные варианты данных (использовать регулярку)

    companion object {
        @JvmStatic
        fun providePhoneNumbers() = listOf(
            arrayOf("81234567890", "+7 (123) 456-78-90"),
            arrayOf("8(123)4567890 Вася", "+7 (123) 456-78-90"),
            arrayOf("7(123)4567890", "+7 (123) 456-78-90")
        )
    }

}
}