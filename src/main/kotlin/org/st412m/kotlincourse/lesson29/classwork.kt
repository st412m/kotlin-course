package org.st412m.kotlincourse.lesson29

import java.time.Duration
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {
    val instant = Instant.now() // для работы с метками времени - timestamp, хранит время в секундах
    println(instant.toEpochMilli())

    val dateTimeNow = LocalDate.now() //работает с датами, не учитывает временную зону, так же как и instant. Хранит
    // в себе год, месяц и день
    val birthday = LocalDate.of(1983, 10, 2) // .of позволяет записать некую дату
    println(dateTimeNow)
    println(birthday)

    val localTimeNow = LocalTime.now() // для работы со временем без учета дат и часовых поясов
    val endOfTheMyWorkingDay = LocalTime.of(18, 0, 0, 0) //аналогично можно задать время без дней месяцев и т.п. т.е.
    // часы, минуты, секунды, наносекунды

    val localDateTime = LocalDateTime.now() // всё вместе
    val alarmClock = LocalDateTime.of(2024, 4, 1, 9, 0, 0)  // аналогично можно задать время с датой

    val vaticanCurrentTime = ZonedDateTime.now(ZoneId.of("Europe/Vatican")) // может хранить дату, время и часовой пояс
    val mobileWorldCongress = ZonedDateTime.of(2024, 2, 26, 10, 0, 0, 0, ZoneId.of("Europe/Madrid"))

    val birthdayInDubai = OffsetDateTime.of(birthday.atTime(19,0), ZoneOffset.of("+09:00")) // учитывает смещение
// atTime - преобразует LocalDate в LocalDateTime, путем добавления часов и минут ZoneOffset указывает
// непосредственно смещение

    // МЕТОДЫ
    val vaticanCurrentTimeInstant = vaticanCurrentTime.toInstant()

    val birthdayInstant = birthday.atTime(19, 0).toInstant(ZoneOffset.of("+09:00"))// нужно передать в каком часовом
    // поясе все происходит

    val instantToZonedDateTime = instant.atZone(ZoneId.systemDefault())

    val instantToOffsetDateTime = instant.atOffset(ZoneOffset.of("-02:00"))

    LocalDate.now().plusYears(1)

    LocalDateTime.now().plusSeconds(1)

    LocalDate.now().minusYears(1)

    Period.between(birthday, LocalDate.now()) // период от одной даты до другой даты в годах, месяцах и днях

    Duration.between(alarmClock, LocalDateTime.now()) // хранит разницу в виде секунд

    alarmClock.isAfter(localDateTime) // проверяет, является ли alarmClock после даты LocalDateTime(вернет true или
    // false)

    alarmClock.isBefore(localDateTime) // аналогично, но до

    alarmClock.isEqual(localDateTime) // для проверки равенства

    val nextAlarmClock = alarmClock.plus(5, ChronoUnit.MINUTES) // ChronoUnit что именно plus прибавляет
    val nextBirthday = birthday.plusYears(1)

    val nanoSeconds = Duration.ofNanos(200) // объект длительностью в наносекундах в данном случае
    println(nanoSeconds.dividedBy(4).toNanos()) // метод divideBy позволяет разделить на части
    println(nanoSeconds.plus(Duration.ofSeconds(2)).toNanos())
    val seconds = Duration.ofSeconds(45)
    println(seconds.minusMinutes(1).seconds)
    val period = Period.of(2, 4, 10) // можно задать в годах месяцах и днях
    println(period.minusMonths(13).toTotalMonths()) //при конвертации в месяцы дня потеряются(не учитывает кол-во
    // дней в месяце, високосные года)
    val periodFromConferenceToBirthday = Period.between(mobileWorldCongress.toLocalDate(), birthday) // необходимо
    // сначала указывать дату в прошлом, а потом в будущем, иначе будет отрицательное значение
    println("${periodFromConferenceToBirthday.years} лет ${periodFromConferenceToBirthday.months} месяцев ${periodFromConferenceToBirthday.days} дней")


    // Форматирование дат
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ") // класс, который позволяет указать
    // формат даты и времени(полностью всё)

    val formattedDate = vaticanCurrentTime.format(formatter)

    println("Текущая дата и время с миллисекундами и часовым поясом: $formattedDate")

    val isoFormatter = DateTimeFormatter.ISO_DATE_TIME //предопределенный формат

    val isoFormattedDate = birthdayInDubai.format(isoFormatter)

    println(isoFormattedDate)

    val prettyFormatter = DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd") // создание собственного
    // паттерна вывода, не забывать про одиночные кавычки

    val prettyFormattedDate = dateTimeNow.format(prettyFormatter)

    println(prettyFormattedDate)



//    try {
//        println("При форматировании с часовым поясом помни, что в LocalDateTime его нет и будет ошибка ${localDateTime.format(formatter)}")
//    } catch (e: Throwable) {
//        e.printStackTrace()
//    }
//
//    try {
//        println("При форматировании LocalDate помни, что нет полей времени и будет ошибка ${birthday.format(formatter)}")
//    } catch (e: Throwable) {
//        e.printStackTrace()
//    }

    val parsedDate = LocalDate.parse(prettyFormattedDate, prettyFormatter) //парсинг, куда мы передаем строку и
    // форматтер и появляется объект LocalDate с заполненными полями
    println(parsedDate)

}
//