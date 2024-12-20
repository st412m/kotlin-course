package org.st412m.kotlincourse.lesson31

class Calculator() {

    fun plus(a: Int, b: Int) = a + b
}
/*
засунуть это в build.gradle.kts в
testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}
 */
