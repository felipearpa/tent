package com.felipearpa.product.list.ui

import com.felipearpa.product.domain.Product

fun Product.toProductModel() =
    ProductModel(
        id = this.id,
        title = this.title,
        price = this.price,
        salePrice = this.salePrice,
        condition = this.condition.toString().lowercase(),
        thumbnail = this.thumbnail,
        installment = this.installment.toInstallmentModel(),
        shipping = this.shipping.toShippingModel()
    )
