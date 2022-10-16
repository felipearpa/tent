package com.felipearpa.tent.product.data

import com.google.gson.annotations.SerializedName

data class ShippingResponse(
    @SerializedName("free_shipping") val isFreeShipping: Boolean
)