package com.felipearpa.product.domain

import com.google.gson.annotations.SerializedName

data class ShippingResponse(
    @SerializedName("free_shipping") val isFreeShipping: Boolean
)