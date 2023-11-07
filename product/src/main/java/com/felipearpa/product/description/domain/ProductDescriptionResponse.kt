package com.felipearpa.product.description.domain

import com.google.gson.annotations.SerializedName

data class ProductDescriptionResponse(@SerializedName("plain_text") val plainText: String)