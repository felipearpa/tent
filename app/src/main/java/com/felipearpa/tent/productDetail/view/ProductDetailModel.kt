package com.felipearpa.tent.productDetail.view

import com.felipearpa.tent.product.domain.ProductCondition

data class ProductDetailModel(
    val id: String,
    val title: String,
    val description: String?,
    val price: Int,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val condition: ProductCondition,
    val shipping: ProductShippingModel,
    val pictures: List<ProductPictureModel>,
    val attributes: List<ProductAttributeModel>,
    val isProtectedPurchase: Boolean
)