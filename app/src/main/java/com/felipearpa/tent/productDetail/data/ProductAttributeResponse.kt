package com.felipearpa.tent.productDetail.data

import com.google.gson.annotations.SerializedName

data class ProductAttributeResponse(
    val id: String,
    val name: String,
    @SerializedName("value_name") val valueName: String
)