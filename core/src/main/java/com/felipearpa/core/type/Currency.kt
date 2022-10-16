package com.felipearpa.core.type

data class Currency(val value: Double) {

    init {
        if (value < 0) {
            throw IllegalArgumentException("Value must be great than zero")
        }
    }

    override fun toString(): String = value.toString()

}