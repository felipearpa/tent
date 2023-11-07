package com.felipearpa.product.detail.domain

fun ProductShippingResponse.toProductShipping() =
    ProductShipping(isFreeShipping = this.isFreeShipping)
