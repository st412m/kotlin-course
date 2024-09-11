package org.st412m.kotlincourse.lesson3

//Погрузимся в атмосферу "Hackathon Survival": Марафон, где участники пытаются завершить реальный проект в условиях
// искусственно созданного хаоса (например, часто меняющиеся требования, неожиданные "сбои" в оборудовании)
//Для каждого из полей подбери наилучший способ хранения из известных тебе. Учитывай такие факторы, как изменяемость,
// обязательность, возможность начальной установки, ресурсоёмкие вычисления значения, необходимость проверки
// устанавливаемого значения на валидность или запрет доступа на установку при возможности чтения, публичность и
// приватность данных.

//Название мероприятия (неизменяемое, строковое, константа)

//Дата проведения (изменяемое, строковое)

//Место проведения (изменяемое, строковое)

//Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.(берется из
// общего бюджета и вычитается)

//Количество участников(изменяемое, числовое, целое get set, но не больше чем максимальное количества людей,
// которое поместится-жюри, судьи, организаторы)

//Длительность хакатона(изменяемое, числовое, double get set)

//Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.(by lazy)

//Текущее состояние хакатона (статус) (изменяемое, строковое, "начало, презентация, соревнование, награждение и т.п.")

//Список спонсоров

//Бюджет мероприятия

//Текущий уровень доступа к интернету

//Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами(by lazy)

//Количество команд

//Перечень задач

//План эвакуации

//Список доступного оборудования

//Список свободного оборудования

//График питания участников (зависит от поставщика питания, определяемого за неделю до начала)

//План мероприятий на случай сбоев

//Список экспертов и жюри

//Методы и процедуры для сбора отзывов от участников и гостей, включая анонимные опросы и интервью.

//Политика конфиденциальности

//Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.

//Текущая температура в помещении

//Мониторинг и анализ производительности сетевого оборудования и интернет-соединения.

//Уровень освещения

//Лог событий мероприятия

//Доступность медицинской помощи

//Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.

//Регистрационный номер мероприятия

//Максимально допустимый уровень шума в помещении хакатона.

//Индикатор превышения уровня шума в помещениях

//Формат мероприятия (зависит от геополитической обстановки)

//Количество свободных мест для отдыха (например, кресел или диванов), сеттер валидирует, чтобы количество не было
// меньше нуля.

//План взаимодействия с прессой

//Детальная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона
// автоматизированных проверок.

//Статус получения всех необходимых разрешений

//Указывает, открыт ли доступ к эксклюзивным ресурсам (например, специальному оборудованию)

//Список партнеров мероприятия

//Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.

//План распределения призов

//Контактная информация экстренных служб, медицинского персонала и других важных служб, недоступная участникам.

//Особые условия для участников с ограниченными возможностями

//Общее настроение участников (определяется опросами)

//Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед
// началом мероприятия.

//Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия.

//Максимальное количество людей, которое может вместить место проведения.

//Стандартное количество часов, отведенное каждой команде для работы над проектом.

//Текущая температура в помещении
