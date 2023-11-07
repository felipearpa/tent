package com.felipearpa.product.detail.domain

import com.google.gson.annotations.SerializedName

data class ProductDetailResponse(
    val id: String,
    val title: String,
    val price: Double,
    @SerializedName("available_quantity") val availableQuantity: Int,
    @SerializedName("sold_quantity") val soldQuantity: Int,
    val condition: String,
    val shipping: ProductShippingResponse,
    val pictures: List<ProductPictureResponse>,
    val attributes: List<ProductAttributeResponse>,
    @SerializedName("accepts_mercadopago") val isProtectedPurchase: Boolean
)