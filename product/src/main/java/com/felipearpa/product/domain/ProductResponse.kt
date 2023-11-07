package com.felipearpa.product.domain

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    val id: String,
    val title: String,
    val price: Double,
    val salePrice: Double?,
    val condition: String,
    val thumbnail: String,
    @SerializedName("installments") val installment: InstallmentResponse,
    val shipping: ShippingResponse
)