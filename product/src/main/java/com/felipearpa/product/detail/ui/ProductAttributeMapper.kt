package com.felipearpa.product.detail.ui

import com.felipearpa.product.detail.domain.ProductAttribute

fun ProductAttribute.toProductAttributeModel() =
    ProductAttributeModel(
        id = this.id,
        name = this.name,
        valueName = this.valueName
    )
