package org.st412m.kotlincourse.lesson3

import sun.jvm.hotspot.ci.ciField
import kotlin.properties.Delegates

//Погрузимся в атмосферу "Hackathon Survival": Марафон, где участники пытаются завершить реальный проект в условиях
// искусственно созданного хаоса (например, часто меняющиеся требования, неожиданные "сбои" в оборудовании)
//Для каждого из полей подбери наилучший способ хранения из известных тебе. Учитывай такие факторы, как изменяемость,
// обязательность, возможность начальной установки, ресурсоёмкие вычисления значения, необходимость проверки
// устанавливаемого значения на валидность или запрет доступа на установку при возможности чтения, публичность и
// приватность данных.

//Название мероприятия (неизменяемое, строковое, константа)

const val EVENTTITLE: String = "Hackathon Survival"

//Дата проведения (изменяемое, строковое)
var eventDay: String = "13.09.2024"

//Место проведения (изменяемое, строковое)
var eventLocation: String = "г.Москва, ул.Пушкина, 'Дом Колотушкина'"

//Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
val expenses: String by lazy {
    "путь к файлу, где вот это вот всё"
}

//Количество участников(изменяемое, числовое, целое get set, но не больше чем максимальное количества людей,
// которое поместится)
var numberParticipants: Int = 0
    set(value) {
        if (value < maximumPeople ) {
            field += value
        } else {
            print("Вы кто такие? Я вас не звал! Идите...")
        }
    }

//Длительность хакатона(изменяемое, числовое, double, так как может измениться место, то и время так же может
// меняться в зависимсти от договоренностей)
var durationEvent: Double = 12.5

//Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.(лишним людям знать не
// обязательно)
val termsAgreements: String by lazy {
    "путь куда-то там к файлу со всей этой требухой"
}

//Текущее состояние хакатона (статус) (изменяемое, строковое, "начало, презентация, соревнование, награждение и т.п.")
var eventStatus: String = "Подготовка"

//Список спонсоров (могут добавиться, могут соскочить, путь к файлу)
lateinit var sponsorsList: String

//Бюджет мероприятия(изменяемый, т.к. спонсоры выше)
var eventBudget: Double = 1_000_000.1

//Текущий уровень доступа к интернету
var internetAvailable: Boolean = true //доступен

//Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами)(нужно
// только во время подготовки, хотя пункт вообще мутный, его разбивать надо в части координации)
val logistics: String = "путь к таблице, где чего-то там меняется"

//Количество команд
var numberTeams: Int = 0
    set(value) {
        field += value}

//Перечень задач(если я правильно понял, это перечень задач для выполнения на хакатоне)
val listTasks: String by lazy {
    "путь к файлу с задачами"
}

//План эвакуации (путь к файлу с планом)
val evacuationPlan: String by lazy {
    "путь к файлу с задачами"
}

//Список доступного оборудования (нужен один раз)
val availableEquipment: String by lazy {
    "путь к списку"
}

//Список свободного оборудования (нужен периодически)
val freeEquipment: String = "путь к списку"

//График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
var foodSupplier: String = ""
var mealSchedule: String = ""
    set(value) {
        if (foodSupplier in termsAgreements
        )
        field = value
    }

//План мероприятий на случай сбоев
val contingencyPlan: String by lazy {
    "путь к плану"
}

//Список экспертов и жюри
val listExperts: String = "путь к файлу с экспертами и жюрями"

//Методы и процедуры для сбора отзывов от участников и гостей, включая анонимные опросы и интервью.(нужен один раз)
val feedbackMethods: String by lazy {
    "путь к методам"
}

//Политика конфиденциальности
val privacyPolicy: String by lazy {
    "путь к политике"
}

//Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
val feedback: String = "путь к месту где эти отзывы собираются"

//Текущая температура в помещении
var indoorTemperature: Double = 0.0
    set(value) {
        "тут API датчика температуры"
        field = value
    }

//Мониторинг и анализ производительности сетевого оборудования и интернет-соединения.
var downloadSpeed: Double = 0.00
    set(value) {
        "стучимся по API на speedtest.com и берем оттуда значение Download speed"
        field = value
    }

var uploadSpeed: Double = 0.00
    set(value) {
        "стучимся по API на speedtest.com и берем оттуда значение Upload speed"
        field = value
    }

var ping: Int = 0
    set(value) {
        "стучимся по API на speedtest.com и берем оттуда значение Ping"
        field = value
    }

//Уровень освещения
var indoorLighting: Double = 0.0
    set(value) {
        "тут API датчика освещенности"
        field = value
    }

//Лог событий мероприятия
var currentTime: String = ""
    set(value) {
        "каким-то образом получаем текущее время"
        field = value
    }
var logEvent: String = ""
    set(value) {
        field = currentTime + eventStatus // добавляем в список время и событие
    }

//Доступность медицинской помощи
var availabilityMedicalAssistance: Boolean = false
var medicalAssistance: String = ""
    set(value) {
        if (medicalAssistance in termsAgreements
        )
            availabilityMedicalAssistance = true
    }


//Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
val securityProcedures: String by lazy {
    "путь к планам"
}

//Регистрационный номер мероприятия
const val regNumber: String = "QWERTY-1234/23958934"

//Максимально допустимый уровень шума в помещении хакатона.
const val maxNoise: Int = 99

//Индикатор превышения уровня шума в помещениях
var noise: Int = 0
    get() = field
    set(value) {
        "получаем данные с датчика уровня шума"
        field = value
    }

var noiseLevel: String = ""
    set(value) {
        if (noise > maxNoise)
        field = "вырубайте шарманку!"
    }

//Формат мероприятия (зависит от геополитической обстановки)
var geopoliticalSituation: String ="" // дружим, воюем, опасаемся
var eventFormat: String = "публичное мероприятие"
    set(value) {
        if (geopoliticalSituation != "дружим")
        field = "Атас, менты! Всем улыбаться!"
    }

//Количество свободных мест для отдыха (например, кресел или диванов), сеттер валидирует, чтобы количество не было
// меньше нуля.
var freePlacesRest: Int = 100
    get() = field
    set(value) {
        if (field <= 0)
            print("Местов нет!")
    }

//План взаимодействия с прессой
val pressWorkPlan: String by lazy {
    "путь к планам"
}

//Детальная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона
// автоматизированных проверок.
val teamPproject: String = "путь к проекту отдельной команды"

var listTeamsProject: String = ""
    get() = field
    set(value) {
        field + teamPproject
        field = value
    }

//Статус получения всех необходимых разрешений
var permissionsStatus: Boolean = false

//Указывает, открыт ли доступ к эксклюзивным ресурсам (например, специальному оборудованию)
var accessExclusive by Delegates.notNull<Boolean>() //я без понятия что это, мне так идея код исправила

//Список партнеров мероприятия
val listPartners: String = "путь к списку"

//Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
lateinit var eventReport: String  //какой-то там путь где-то потом, если менты не прикроют лавочку

//План распределения призов
val prizeDistributionPlan: String = "путь к плану"

//Контактная информация экстренных служб, медицинского персонала и других важных служб, недоступная участникам.
val contactsSpecialServices: String = "путь к файлу"

//Особые условия для участников с ограниченными возможностями
val participantsDisabilities: String = "путь к файлу"

//Общее настроение участников (определяется опросами)
val polls: String = "путь к опросам"
var mood: String= ""
    set(value) {
        "тут короч, фигня, которая смотрит чего-там в файле polls и вычисляет среднее"
        field = value
    }

//Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед
// началом мероприятия.
val eventPlan: String by lazy {
    "путь к плану"
}

//Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия.
lateinit var specialGuest: String

//Максимальное количество людей, которое может вместить место проведения.(изменяемая, т.к если меняем место, то может
// изменится и максимальное число людей, которое туда влезет, цельночисленная)

var maximumPeople: Int = 1000

//Стандартное количество часов, отведенное каждой команде для работы над проектом.
const val timeTask: Double = 2.5

//Текущая температура в помещении
//var indoorTemperature: Double = 0.0
//    set(value) {
//        "тут API датчика температуры"
//        field = value
//    }

