package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductPicture

fun ProductPicture.toProductPictureModel() =
    ProductPictureModel(
        id = this.id,
        url = this.url,
        secureUrl = this.secureUrl,
        width = this.size.width,
        height = this.size.height
    )
