package com.felipearpa.tent.formatter

interface CurrencyFormatter {

    fun format(value: Any, decimalsCount: Int? = null): String

}