package com.felipearpa.tent.product.data

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    val id: String,
    val title: String,
    val price: Long,
    val salePrice: Long?,
    val condition: String,
    val thumbnail: String,
    @SerializedName("installments") val installment: InstallmentResponse,
    val shipping: ShippingResponse
)