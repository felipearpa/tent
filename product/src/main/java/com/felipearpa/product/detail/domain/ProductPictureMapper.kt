package com.felipearpa.product.detail.domain

import com.felipearpa.product.type.PictureSize

fun ProductPictureResponse.toProductPicture() =
    ProductPicture(
        id = this.id,
        url = this.url,
        secureUrl = this.secureUrl,
        size = PictureSize(this.size)
    )
