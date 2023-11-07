package com.felipearpa.product.list.ui

import com.felipearpa.product.domain.Shipping

fun Shipping.toShippingModel() =
    ShippingModel(isFreeShipping = this.isFreeShipping)
