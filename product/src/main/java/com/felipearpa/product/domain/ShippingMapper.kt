package com.felipearpa.product.domain

fun ShippingResponse.toShipping() =
    Shipping(isFreeShipping = this.isFreeShipping)
