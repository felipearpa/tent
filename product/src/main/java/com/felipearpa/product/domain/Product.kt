package com.felipearpa.product.domain

enum class ProductCondition {
    USED,
    NEW
}

data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val salePrice: Double?,
    val condition: ProductCondition,
    val thumbnail: String,
    val installment: Installment,
    val shipping: Shipping
)