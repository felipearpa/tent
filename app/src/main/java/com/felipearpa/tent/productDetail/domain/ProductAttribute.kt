package com.felipearpa.tent.productDetail.domain

import com.felipearpa.core.type.Identifier
import com.felipearpa.core.type.NonEmptyString

data class ProductAttribute(
    val id: Identifier,
    val name: NonEmptyString,
    val valueName: NonEmptyString
)