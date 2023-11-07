package com.felipearpa.core.formatter

import java.text.NumberFormat
import java.util.Locale
import javax.inject.Inject

class ColombianCurrencyFormatter @Inject constructor() : CurrencyFormatter {
    override fun format(value: Any, decimalsCount: Int?): String {
        val formatter = NumberFormat.getCurrencyInstance(Locale("es", "co"))
        decimalsCount?.let { nonNullDecimalsCount ->
            formatter.minimumFractionDigits = nonNullDecimalsCount
            formatter.maximumFractionDigits = decimalsCount
        }
        return formatter.format(value)
    }
}