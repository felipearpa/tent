package com.felipearpa.product.detail.domain

import com.google.gson.annotations.SerializedName

data class ProductPictureResponse(
    val id: String,
    val url: String,
    @SerializedName("secure_url") val secureUrl: String,
    val size: String
)