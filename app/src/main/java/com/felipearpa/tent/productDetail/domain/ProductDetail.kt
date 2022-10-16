package com.felipearpa.tent.productDetail.domain

import com.felipearpa.core.type.Currency
import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString
import com.felipearpa.core.type.Quantity
import com.felipearpa.tent.product.domain.ProductCondition
import com.felipearpa.tent.productDescription.domain.ProductDescription

data class ProductDetail(
    val id: Identifier,
    val title: NonEmptyString,
    val description: ProductDescription?,
    val price: Currency,
    val availableQuantity: Quantity,
    val soldQuantity: Quantity,
    val condition: ProductCondition,
    val shipping: ProductShipping,
    val pictures: List<ProductPicture>,
    val attributes: List<ProductAttribute>,
    val isProtectedPurchase: Boolean
)