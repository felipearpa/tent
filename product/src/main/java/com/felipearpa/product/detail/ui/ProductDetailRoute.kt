package com.felipearpa.product.detail.ui

object ProductDetailRoute {
    enum class Param(val identifier: String) {
        PRODUCT_ID("productId")
    }

    val route: String = "product/{${Param.PRODUCT_ID.identifier}}/detail"

    fun route(productId: String): String =
        route.replace("{${Param.PRODUCT_ID.identifier}}", productId)
}