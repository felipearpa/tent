package com.felipearpa.product.domain

fun ProductResponse.toProduct() =
    Product(
        id = this.id,
        title = this.title,
        price = this.price,
        salePrice = this.salePrice,
        condition = ProductCondition.valueOf(this.condition.uppercase()),
        thumbnail = this.thumbnail,
        installment = this.installment.toInstallment(),
        shipping = this.shipping.toShipping()
    )
