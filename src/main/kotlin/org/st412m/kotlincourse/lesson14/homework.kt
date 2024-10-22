package org.st412m.kotlincourse.lesson14
/*
Для решения каждой задачи постарайтесь использовать наиболее подходящий метод, не повторяясь с решением других
задач.
 */

fun main(){

/*
Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время
выполнения теста.
 */
    val averTest = mapOf<String, Double>()
    val average = if (averTest.isNotEmpty()) {
        averTest.values.sum() / averTest.size
    } else {
        0.0
    }
    println(average)

/*
Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения-строка
с метаданными. Выведите список всех тестовых методов.
 */

    val autoTest = mapOf<String, String>()
    println(autoTest.map { it.key })


/*
В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.  Посчитайте количество
успешных тестов в словаре с результатами.
 */
    val autoTest1 = mutableMapOf<String, String>()
    autoTest1["Login"] = "Passed"
    println( autoTest1.count { it.value == "Passed" } )

/*
Удалите из изменяемого словаря с баг -трекингом запись о баге, который был исправлен.
 */
    val bugTrack = mutableMapOf<Int, String>()  // Int, так как ключ это Bug ID
    bugTrack.remove(1234)

/*
Для словаря с результатами тестирования веб -страниц(ключ — URL страницы, значение — статус ответа), выведите сообщение
о странице и статусе её проверки.
 */
    val webTests = mapOf<String, Int>()
    webTests.forEach { _ ->
        println("${webTests.keys} - ${webTests.values}") }

/*
Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
 */
    val responseTime = mapOf<String, Long>()
    val threshold = 1000
    println(responseTime.filterValues { it > threshold })

/*
В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в строке).
Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
 */
    val testApi = mapOf<String, String>()
    println(testApi.getOrDefault("endpoint") { println("Не тестировался")})

/*
Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации), получите значение
для "browserType". Ответ не может быть null.
 */
    val testConf = mapOf<String, String >()
    println(testConf.getOrElse("browserType") { println("Default Browser")})

/*
Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, чтобы добавить новую версию.
 */
    val version = mapOf<String, String>()
    val versionMutable = version.toMutableMap()

/*
Используя словарь с настройками тестирования для различных мобильных устройств(ключ — модель устройства), получите
настройки для конкретной модели или верните настройки по умолчанию.
 */
    val testSet = mapOf<String, List<String>>()
    val defaultSet = ("default, default, default")
    println(testSet.getOrDefault("Nokia 3110", defaultSet))

/*
Проверьте, содержит ли словарь с ошибками тестирования (код и описание) определенный код ошибки.
 */
    val errorMap = mapOf<Int, String>()
    println(errorMap.containsKey(404))


/*
Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив
только те сценарии, идентификаторы которых соответствуют определённой версии тестов.
 */
    val testScripts = mapOf<String, String>()
    val testScriptsFiltered = testScripts.filterValues { it == "Passed" }

/*
У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования.
Проверьте, есть ли модули с неудачным тестированием.
 */
    val testModules = mapOf<String, String>()
    println(testModules.all { it.value == "Failed" })

/*
Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря .
 */
    val setupTests = mutableMapOf<String, String>()
    setupTests.putAll(testConf)

/*
Объедините два неизменяемых словаря с данными о багах.
 */
    val bug1 = mapOf<Int, String>()
    val bug2 = mapOf<Int, String>()
    val addBugs = bug1 + bug2

/*
Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.Исключите из отчета по
автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”)
 */
    val tempDate = mutableMapOf<Int, String>()
    val filteredTempDate = tempDate.filterValues { it == "skipped" }
    tempDate.clear()
    tempDate.putAll(filteredTempDate)

/*
Удалите из словаря с конфигурациями тестирования набор устаревших конфигураций.Создайте отчет о тестировании,
преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат) в список строк
формата "Test ID: результат".
 */
    val testConf1 = mutableMapOf<Int, String>()
    testConf1.values.remove("outdated" )
    val testReport = testConf1.map { "Test ID: ${it.key} результат: ${it.value}" }


/*
Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
Преобразуйте словарь, содержащий ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов
на их названия (название можно получить вызвав фейковый метод, например getNameById(id: String))
 */
    val testResult2 = mutableMapOf(1 to 120, 2 to 100, 3 to 14, 4 to 88, 5 to 666)
    val archTestResult2: Map<String, Int> = testResult2.mapKeys { (id, _) -> getNameById(id) }.toMap()
    //val archTestResult2: Map<String, Int> = testResult2.map { (id, value) -> getNameById(id) to value }.toMap()
    println(archTestResult2)

/*
Для словаря с оценками производительности различных версий приложения увеличьте каждую оценку на 10 %, чтобы учесть
новые условия тестирования.
 */
    val perfAss = mutableMapOf<String, Int>()
    perfAss.mapValues { it.value * 1.10 }
    //perfAss.map { it.key to (it.value * 1.10).toInt() }.toMap()

/*
Проверьте, пуст ли словарь с ошибками компиляции тестов.
 */
    val compError = mapOf<Int, String>()
    compError.isEmpty()

/*
Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
 */
    val loadTest = mapOf<Int, String>()
    loadTest.isNotEmpty()

/*
Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
 */
    val autoTests = mapOf<Int, String>()
    autoTests.all { it.value == "Passed" }

/*
Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
 */
    autoTests.any { it.value == "Failed"}

/*
Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.
 */
    val testResult3 = mapOf<String, String>()
    testResult3.filter { it.key.contains("optional") && it.value == "Failed" }

}

fun getNameById(id: Int): String {
    return "Test $id"
    }
