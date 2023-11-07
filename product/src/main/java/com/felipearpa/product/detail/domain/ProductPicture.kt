package com.felipearpa.product.detail.domain

import com.felipearpa.product.type.PictureSize

data class ProductPicture(
    val id: String,
    val url: String,
    val secureUrl: String,
    val size: PictureSize
)