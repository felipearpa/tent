package com.felipearpa.tent.product.domain

import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Quantity

data class Installment(
    val quantity: Quantity,
    val amount: Currency
)