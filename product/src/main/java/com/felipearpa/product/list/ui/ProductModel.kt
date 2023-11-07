package com.felipearpa.product.list.ui

data class ProductModel(
    val id: String,
    val title: String,
    val price: Double,
    val salePrice: Double?,
    val condition: String,
    val thumbnail: String,
    val installment: InstallmentModel,
    val shipping: ShippingModel
)