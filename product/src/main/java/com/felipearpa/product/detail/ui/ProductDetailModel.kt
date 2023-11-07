package com.felipearpa.product.detail.ui

import com.felipearpa.product.domain.ProductCondition

data class ProductDetailModel(
    val id: String,
    val title: String,
    val description: String?,
    val price: Double,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val condition: ProductCondition,
    val shipping: ProductShippingModel,
    val pictures: List<ProductPictureModel>,
    val attributes: List<ProductAttributeModel>,
    val isProtectedPurchase: Boolean
)