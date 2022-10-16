package com.felipearpa.core.type

data class NonEmptyString(val value: String) {

    init {
        if (value.isBlank()) {
            throw IllegalArgumentException("Value must be not empty")
        }
    }

    override fun toString(): String = value

}