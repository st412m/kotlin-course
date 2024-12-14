package org.st412m.kotlincourse.lesson29.homework

import java.time.LocalDate

private val BOOMER_START_DATE = LocalDate.of(1946, 1, 1)
private val BOOMER_END_DATE = LocalDate.of(1964, 12, 31)
private val ZOOMER_START_DATE = LocalDate.of(1997, 1, 1)
private val ZOOMER_END_DATE = LocalDate.of(2012, 12, 31)

fun identifyGeneration(birthDate: LocalDate): String {
    return when {
        !birthDate.isBefore(BOOMER_START_DATE) && !birthDate.isAfter(BOOMER_END_DATE) -> "Бумер"
        !birthDate.isBefore(ZOOMER_START_DATE) && !birthDate.isAfter(ZOOMER_END_DATE) -> "Зумер"
        else -> "Не определено"
    }
}