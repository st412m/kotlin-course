package org.st412m.kotlincourse.lesson29.homework

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun main() {
    /*
    Создай текущую временнУю метку и выведи её на печать (чтобы ещё раз запомнить название этого класса)
    */
    println("\n-----Задача 1------")
    val currentTimeStamp = Instant.now()
    println(currentTimeStamp)

    /*
    Создай дату своего дня рождения.
    */
    println("\n-----Задача 2------")
    val myBirthday = LocalDate.of(1977, 5, 22)
    println(myBirthday)

    /*
    Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    */
    println("\n-----Задача 3------")
    val differenceMyBirthdayAndNow = Period.between(myBirthday, LocalDate.now())
    println(differenceMyBirthdayAndNow.years)

    /*
    Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит ли
    аргумент время и часовой пояс. Temporal - это общий тип для разных классов даты-времени. В форматированном значении
    нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном объекте. Обработай в методе все
    типы дат, которые знаешь. Реализуй два варианта функции - с собственный форматированием и с форматами из ISO коллекции.

     Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше.
     Не используй в них метод now()
   */
    println("\n-----Задача 4-5------")
    val localDate = LocalDate.of(2024, 12, 14)
    val localDateTime = LocalDateTime.of(2024, 12, 14, 13, 50, 22)
    val zonedDateTime = ZonedDateTime.of(
        2024, 12, 14, 13, 50, 35,
        43, ZoneId.of("Europe/Moscow")
    )
    val offsetDateTime = OffsetDateTime.of(
        2024, 12, 14, 13, 50, 35,
        43, ZoneOffset.of("+04:00")
    )
    val instant = Instant.ofEpochMilli(2342342)

    println("Кросевое форматирование:")
    println(formatTemporalCustom(localDate))
    println(formatTemporalCustom(localDateTime))
    println(formatTemporalCustom(zonedDateTime))
    println(formatTemporalCustom(offsetDateTime))
    println(formatTemporalCustom(instant))

    println("\nФорматирование с ISO:")
    println(formatTemporalISO(localDate))
    println(formatTemporalISO(localDateTime))
    println(formatTemporalISO(zonedDateTime))
    println(formatTemporalISO(offsetDateTime))
    println(formatTemporalISO(instant))


    /*
    Создайте функцию identifyGeneration, которая принимает дату рождения в формате LocalDate и печатает строку,
    определяющую, к какому поколению принадлежит человек: "Бумер" для тех, кто родился с 1946 по 1964 год включительно,
    и "Зумер" для тех, кто родился с 1997 по 2012 год включительно. Если дата рождения не попадает ни в один из этих
    диапазонов, функция должна возвращать "Не определено". Для сравнения дат используй методы
    isAfter(otherDate) и isBefore(otherDate). Объекты с эталонными датами вынеси в приватные
    поля файла с методом identifyGeneration.
     */
    println("\n-----Задача 6------")
    val birthDate1 = LocalDate.of(1953, 3, 11)
    val birthDate2 = LocalDate.of(2000, 4, 27)
    val birthDate3 = LocalDate.of(1977, 5, 22)

    println("Поколение: ${identifyGeneration(birthDate1)}")
    println("Поколение: ${identifyGeneration(birthDate2)}")
    println("Поколение: ${identifyGeneration(birthDate3)}")

    /*
    Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует
    дату в месяц и день.
    Выведи первую отформатированную дату, прибавив к ней 10 дней.
    Выведи вторую отформатированную дату, прибавив к ней 10 дней.
    Найди отличия)))
    */

    val february23 = LocalDate.of(2023, 2, 25)
    val february24 = LocalDate.of(2024, 2, 25)

    val formatter = DateTimeFormatter.ofPattern("MMMM dd")

    val updatedFebruary23 = february23.plusDays(10)
    val updatedFebruary24 = february24.plusDays(10)

    println("Первая дата (2023): ${updatedFebruary23.format(formatter)}")
    println("Год ${february23.year} високосный: ${isLeapYear(february23)}")
    println("Вторая дата (2024): ${updatedFebruary24.format(formatter)}")
    println("Год ${february24.year} високосный: ${isLeapYear(february24)}")



}


