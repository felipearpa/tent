package com.felipearpa.product.detail.domain

import com.felipearpa.product.domain.ProductCondition

fun ProductDetailResponse.toProductDetail() =
    ProductDetail(
        id = this.id,
        title = this.title,
        description = null,
        price = this.price.toDouble(),
        availableQuantity = this.availableQuantity,
        soldQuantity = this.soldQuantity,
        condition = ProductCondition.valueOf(this.condition.uppercase()),
        shipping = ProductShipping(
            isFreeShipping = this.shipping.isFreeShipping
        ),
        pictures = this.pictures.map { productPictureResponse -> productPictureResponse.toProductPicture() },
        attributes = this.attributes.map { productAttributeResponse -> productAttributeResponse.toProductAttribute() },
        isProtectedPurchase = this.isProtectedPurchase
    )
