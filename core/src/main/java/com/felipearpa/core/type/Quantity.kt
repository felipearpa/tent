package com.felipearpa.core.type

data class Quantity(val value: Int) {

    init {
        if (value < 0) {
            throw IllegalArgumentException("Value must be great than zero")
        }
    }

    override fun toString(): String = value.toString()

}