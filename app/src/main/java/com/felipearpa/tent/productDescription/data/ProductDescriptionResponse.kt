package com.felipearpa.tent.productDescription.data

import com.google.gson.annotations.SerializedName

data class ProductDescriptionResponse(@SerializedName("plain_text") val plainText: String)