package com.felipearpa.product.list.ui

import com.felipearpa.core.emptyString

fun fakeProductDummy() =
    ProductModel(
        id = "X".repeat(15),
        title = "X".repeat(25),
        price = 100000.0,
        salePrice = 100000.0,
        condition = "X".repeat(10),
        thumbnail = emptyString(),
        installment = InstallmentModel(
            quantity = 10, amount = 1000.0
        ),
        shipping = ShippingModel(
            isFreeShipping = true
        )
    )

fun productDummy() =
    ProductModel(
        id = "MCO959602836",
        title = "Celular Motorola G6 16gb",
        price = 250000.0,
        salePrice = null,
        condition = "used",
        thumbnail = "http://http2.mlstatic.com/D_948488-MCO51510901802_092022-O.jpg",
        installment = InstallmentModel(
            quantity = 36, amount = 6944.44
        ),
        shipping = ShippingModel(
            isFreeShipping = true
        )
    )