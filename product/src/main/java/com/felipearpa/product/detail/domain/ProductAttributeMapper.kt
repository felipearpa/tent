package com.felipearpa.product.detail.domain

fun ProductAttributeResponse.toProductAttribute() =
    ProductAttribute(
        id = this.id,
        name = this.name,
        valueName = this.valueName
    )
