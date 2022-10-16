package com.felipearpa.core.type

data class Url(val value: String) {

    init {
        checkEmpty()
        checkPattern()
    }

    private fun checkPattern() {
        val pattern =
            "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)".toRegex()
        if (!pattern.containsMatchIn(value)) {
            throw IllegalArgumentException("Value must be a valid url")
        }
    }

    private fun checkEmpty() {
        if (value.isBlank()) {
            throw IllegalArgumentException("Value must be not empty")
        }
    }

    override fun toString(): String = value

}