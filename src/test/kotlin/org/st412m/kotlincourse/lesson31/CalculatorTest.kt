package org.st412m.kotlincourse.lesson31

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test  //ипортировать всегда этот


class CalculatorTest {
    @Test
    fun `возвращает 5 при сложении 2 и 3`(){  //писать конечно нужно на английском
        val calc = Calculator()
        val actualResult = calc.plus(2, 3)
        Assertions.assertEquals(5,actualResult, "должно быть 5")
    }

}