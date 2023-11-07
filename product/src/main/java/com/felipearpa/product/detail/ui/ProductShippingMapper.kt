package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductShipping

fun ProductShipping.toProductShippingModel() =
    ProductShippingModel(isFreeShipping = this.isFreeShipping)
