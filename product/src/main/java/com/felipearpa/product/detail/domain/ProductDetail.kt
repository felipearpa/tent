package com.felipearpa.product.detail.domain

import com.felipearpa.product.description.domain.ProductDescription
import com.felipearpa.product.domain.ProductCondition

data class ProductDetail(
    val id: String,
    val title: String,
    val description: ProductDescription?,
    val price: Double,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val condition: ProductCondition,
    val shipping: ProductShipping,
    val pictures: List<ProductPicture>,
    val attributes: List<ProductAttribute>,
    val isProtectedPurchase: Boolean
)