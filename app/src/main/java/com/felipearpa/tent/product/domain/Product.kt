package com.felipearpa.tent.product.domain

import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString
import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Url

enum class ProductCondition {
    USED,
    NEW
}

data class Product(
    val id: Identifier,
    val title: NonEmptyString,
    val price: Currency,
    val salePrice: Currency?,
    val condition: ProductCondition,
    val thumbnail: Url,
    val installment: Installment,
    val shipping: Shipping
)