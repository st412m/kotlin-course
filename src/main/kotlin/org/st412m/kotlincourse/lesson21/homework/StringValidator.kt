package org.st412m.kotlincourse.lesson21.homework

class StringValidator : Validator<String?> {
    override fun validate(value: String?): Boolean {
        return !value.isNullOrBlank()
    }
}