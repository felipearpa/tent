package com.felipearpa.product.type

data class PictureSize(val value: String) {

    var width: Int = 0
        private set

    var height: Int = 0
        private set

    init {
        val parts = value.split("x")

        if (parts.size != 2) {
            throw IllegalArgumentException("Value must be a valid picture size")
        }

        try {
            width = parts.first().toInt()
            height = parts.last().toInt()
        } catch (ex: NumberFormatException) {
            throw IllegalArgumentException("Width and Height must be an integer")
        }
    }

    override fun toString(): String = value

}