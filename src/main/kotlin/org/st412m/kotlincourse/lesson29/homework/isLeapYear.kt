package org.st412m.kotlincourse.lesson29.homework

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year
import java.time.LocalDate

fun isLeapYear(date: LocalDate): Boolean {
    return (date.year % 4 == 0 && date.year % 100 != 0) || (date.year % 400 == 0)
}

//знаю что можно проще - return date.isLeapYear