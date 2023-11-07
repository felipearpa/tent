package com.felipearpa.core.formatter

interface CurrencyFormatter {
    fun format(value: Any, decimalsCount: Int? = null): String
}