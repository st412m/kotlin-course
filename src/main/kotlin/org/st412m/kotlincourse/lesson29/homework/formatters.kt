package org.st412m.kotlincourse.lesson29.homework

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

fun formatTemporalCustom(temporal: Temporal): String {
    return when (temporal) {
        is LocalDate -> temporal.format(
            DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd")
        )

        is LocalDateTime -> temporal.format(
            DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd', часов' HH', минут' mm', секунд' ss")
        )

        is ZonedDateTime -> temporal.format(
            DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd', время' HH:mm:ss:SS', временная зона' z")
        )

        is OffsetDateTime -> temporal.format(
            DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd', время' HH:mm:ss:SS', временная зона' Z")
        )

        is Instant -> temporal.atZone(ZoneId.systemDefault()).format(
            DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd', время' HH:mm:ss', временная зона' z")
        )

        else -> "Неизвестный формат: $temporal"
    }
}

fun formatTemporalISO(temporal: Temporal): String {
    return when (temporal) {
        is LocalDate -> temporal.format(DateTimeFormatter.ISO_DATE)
        is LocalDateTime -> temporal.format(DateTimeFormatter.ISO_DATE_TIME)
        is ZonedDateTime -> temporal.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        is OffsetDateTime -> temporal.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        is Instant -> temporal.atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        else -> "Неизвестный формат: $temporal"
    }
}