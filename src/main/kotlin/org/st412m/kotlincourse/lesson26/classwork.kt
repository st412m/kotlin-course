package org.st412m.kotlincourse.lesson26


fun processWebData(
    query: String,
    fetcher: (String) -> List<Map<String, Any>>,
    transformer: (List<Map<String, Any>>) -> List<User>,
    displayer: (List<User>) -> Unit,
) {
    val rawData = fetcher(query)
    val transformedData = transformer(rawData)
    displayer(transformedData)
}

data class User(val name: String)


fun func1(
    anotherFunc1: () -> Unit
){}

fun func2(
    anotherFunc2: (Int) -> String
    ){
    println(anotherFunc2(56))
}

fun <T> func3(
    arg1: List<T>,
    anotherFunc3: (List<T>) -> T
): T {
    return anotherFunc3(arg1)
}

fun main() {

    val fetcher: (String) -> List<Map<String, Any>> = {
        // orm.select(it).map { listOf() }
        listOf(mapOf("Andrey" to "5"))
    }

    val transformer: (List<Map<String, Any>>) -> List<User> = {
        it.map { map -> User(map.keys.first()) }
    }

    val displayer: (List<User>) -> Unit = {
        println(it)
    }

    processWebData("sql query", fetcher, transformer, displayer) // fetcher, transformer, displayer - это просто
// названия функций, которые мы передаем в processWebData

    val func21: (Int) -> String = {it.toString() + "5"}
    func2(func21)

}