package org.st412m.kotlincourse.lesson15.homework

fun main() {
    /*
Событие: Вечеринка Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String) и
attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.
 */
    println("-----Вечеринка------")
    val party1 = Party("Elm St. 1428", 53)
    party1.details()

    /*
Аспект реальности: Эмоция Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type (String)
и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.
 */
    println("-----Эмоция------")
    val emotion1 = Emotion("радость", 2)
    emotion1.express()


    /*
Природное явление: Луна Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean),
чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны
(например, "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
 */
    println("------Луна------")
    Moon.showPhase()
    Moon.isVisible = true
    Moon.showPhase()


    /*
Покупка: Продукт Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны быть
свойства “название”, “цена”, “количество”.
 */
    println("-----Продукт------")
    val defaultProduct = Product()
    println(defaultProduct)
    val customProduct = Product(name = "Мясо", price = 50.0, quantity = 10)
    println(customProduct)


    /*
Мероприятие: Концерт Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”,
“место проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”. Добавьте метод, который
выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.
 */
    println("-----Концерт------")
    val concert1 = Concert("Кобыла И Трупоглазые Жабы Искали Цезию, Нашли Поздно Утром Свистящего Хна", "ДК им" +
            ".Ленина", 3.62, 1)
    concert1.info()
    concert1.buyTicket()
    concert1.info()
    concert1.buyTicket()



}
