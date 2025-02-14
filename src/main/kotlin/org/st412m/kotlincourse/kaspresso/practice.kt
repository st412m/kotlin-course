package org.st412m.kotlincourse.kaspresso

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher


data class SuspiciousActivity(val isDetected: Boolean, val suspicionLevel: Int, val notes: String)

class IsDetectedMatcher(
    private val isDetected: Boolean
) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("isDetected is $isDetected")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.isDetected == isDetected
    }
}

class SuspicionLevelInRangeMatcher(
    private val min: Int,
    private val max: Int
) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("suspicionLevel is between $min and $max")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.suspicionLevel in min..max
    }
}

class NotesInMatcher(private val validNotes: List<String>) : TypeSafeMatcher<SuspiciousActivity>() {
    override fun describeTo(description: Description) {
        description.appendText("notes is one of $validNotes")
    }

    override fun matchesSafely(activity: SuspiciousActivity): Boolean {
        return activity.notes in validNotes
    }
}

class MatcherBuilder() {
    val listOfMatchers = mutableListOf<Matcher<SuspiciousActivity>>()
    operator fun invoke(function: MatcherBuilder.() -> Unit) {
        function()
    }
    fun detect(isDetected: Boolean) {
        val detectedMatcher = IsDetectedMatcher(isDetected)
        listOfMatchers.add(detectedMatcher)
    }
    fun range(min: Int, max: Int) {
        listOfMatchers.add(SuspicionLevelInRangeMatcher(min, max))
    }
    fun notes(validNotes: List<String>) {
        listOfMatchers.add(NotesInMatcher(validNotes))
    }
    fun buildAllMatchers() = allOf(listOfMatchers)

}

fun main() {
    val activities = listOf(
        SuspiciousActivity(true, 5, "unauthorized access"),
        SuspiciousActivity(false, 4, "unauthorized access"),
        SuspiciousActivity(true, 7, "Kaspresso")
    )

    val matchers = allOf(
        SuspicionLevelInRangeMatcher(3,4),
        NotesInMatcher(listOf("unauthorized access", "security breach"))
    )
    val result = activities.filter { matchers.matches(it) }

    val builder = MatcherBuilder()

    builder {
        detect(true)
        range(5, 12)
        notes(listOf("Kaspresso", "is", "tough"))

    }

    val result1 = activities.filter { builder.buildAllMatchers().matches(it) }

    println(result1)

}