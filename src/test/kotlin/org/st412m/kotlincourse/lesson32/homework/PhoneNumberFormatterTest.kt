package org.st412m.kotlincourse.lesson32.homework
/*
- Напишите параметризованные юнит тесты, которые будут проверять различные варианты входных данных: валидные и
невалидные номера телефонов.
- В тестах используйте различные источники данных для параметров: валидные номера, невалидные номера, номера с лишними
символами, короткие и длинные номера.


Примеры для тестирования:

- `8 (922) 941-11-11` -> `+7 (922) 941-11-11`
- `79229411111` -> `+7 (922) 941-11-11`
- `+7 922 941 11 11` -> `+7 (922) 941-11-11`
- `9229411111` -> `+7 (922) 941-11-11`
- `abc +7 922 941 11 11` -> `+7 (922) 941-11-11`
- `12345` -> `Exception` (невалидный номер)
- `+1 (922) 941-11-11` ->  `Exception` (невалидный номер)
 */

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertFailsWith


class PhoneNumberFormatterTest {

    private val formatter = PhoneNumberFormatter()

    @ParameterizedTest
    @MethodSource("provideValidPhoneNumber")
    fun `the number should be cleared correctly`(
        inputNumber: String,
        expectedNumber: String
    ) {
        val actualNumber = formatter.formatPhoneNumber(inputNumber)
        assertEquals(expectedNumber, actualNumber)
    }

    @ParameterizedTest
    @MethodSource("provideInvalidPhoneNumber")
    fun `the number must consist of the correct number of digits`(
        inputNumber: String,

    ) {
        assertFailsWith<IllegalArgumentException>{
            formatter.formatPhoneNumber(inputNumber)
        }
    }

    companion object {
        @JvmStatic
        fun provideValidPhoneNumber() = listOf(
            Arguments.of("8 (922) 941-11-11", "+7 (922) 941-11-11"),
            Arguments.of("79229411111", "+7 (922) 941-11-11"),
            Arguments.of("+7 922 941 11 11", "+7 (922) 941-11-11"),
            Arguments.of("9229411111", "+7 (922) 941-11-11"),
            Arguments.of("abc +7 922 941 11 11", "+7 (922) 941-11-11"),
        )

        @JvmStatic
        fun provideInvalidPhoneNumber() = listOf(
            Arguments.of("12345"),
            Arguments.of("+1 (922) 941-11-11"),
            Arguments.of("@#$%^*хуй"),
            Arguments.of("8 (922) 941-11-111"),
        )
    }
}