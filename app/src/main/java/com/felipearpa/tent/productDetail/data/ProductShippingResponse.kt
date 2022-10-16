package com.felipearpa.tent.productDetail.data

import com.google.gson.annotations.SerializedName

data class ProductShippingResponse(
    @SerializedName("free_shipping") val isFreeShipping: Boolean
)