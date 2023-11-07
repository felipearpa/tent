package com.felipearpa.product.detail.domain

import com.google.gson.annotations.SerializedName

data class ProductShippingResponse(
    @SerializedName("free_shipping") val isFreeShipping: Boolean
)