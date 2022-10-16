package com.felipearpa.tent.productDetail.domain

import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.Url
import com.felipearpa.tent.type.PictureSize

data class ProductPicture(
    val id: Identifier,
    val url: Url,
    val secureUrl: Url,
    val size: PictureSize
)