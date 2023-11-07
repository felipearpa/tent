package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductDetail

fun ProductDetail.toProductDetailModel() =
    ProductDetailModel(
        id = this.id,
        title = this.title,
        price = this.price,
        availableQuantity = this.availableQuantity,
        soldQuantity = this.soldQuantity,
        condition = this.condition,
        shipping = ProductShippingModel(
            isFreeShipping = this.shipping.isFreeShipping
        ),
        pictures = this.pictures.map { productPicture -> productPicture.toProductPictureModel() },
        attributes = this.attributes.map { productAttribute -> productAttribute.toProductAttributeModel() },
        isProtectedPurchase = this.isProtectedPurchase,
        description = this.description?.plainText
    )
