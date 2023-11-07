package com.felipearpa.product.description.domain

fun ProductDescriptionResponse.toProductDescription() =
    ProductDescription(plainText = this.plainText)
