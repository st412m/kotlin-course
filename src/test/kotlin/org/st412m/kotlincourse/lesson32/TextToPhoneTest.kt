package org.st412m.kotlincourse.lesson32

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

class TextToPhoneTest {

    @Test
    fun `number starts whis +7 should convert to 8`(){
        val actualPhoneNum = textToPhone("81234567890")
        assertEquals("+7 (123) 456-78-90", actualPhoneNum)
    }


    @Test
    fun `number must be cleared`(){
        val actualPhoneNum = textToPhone("812-3(4)567890 Вася")
        assertEquals("+7 (123) 456-78-90", actualPhoneNum)
    }

    @Test
    fun `number must start whis 7`(){
        val actualPhoneNum = textToPhone("+71234567890")
        assertEquals("+7 (123) 456-78-90", actualPhoneNum)
    }
    companion object {
        @JvmStatic
        fun providePhoneNumber() = listOf(
            arrayOf("81234567890", "+7 (123) 456-78-90"),
            arrayOf("812-3(4)567890 Вася", "+7 (123) 456-78-90"),
            arrayOf("+71234567890", "+7 (123) 456-78-90"),
        )
    }
}