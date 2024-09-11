package org.st412m.kotlincourse.lesson3

val chassis: String = "123123ABC"
var color: String = "Blue"
var distance: Double = 0.0
lateinit var owner: String
const val WHEELS: Int = 4
val report: String by lazy {
    ""
}
var fuel: Double = 0.0
   get() = field
   set(value) {
      if (value > 0) field += value
}