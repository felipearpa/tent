package com.felipearpa.tent.product.view

data class ProductModel(
    val id: String,
    val title: String,
    val price: Long,
    val salePrice: Long?,
    val condition: String,
    val thumbnail: String,
    val installment: InstallmentModel,
    val shipping: ShippingModel
)