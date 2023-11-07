package com.felipearpa.product.list.ui

object ProductRoute {
    enum class Param(val identifier: String) {
        FILTER_TEXT("filterText")
    }

    val route: String = "products/{${Param.FILTER_TEXT.identifier}}"

    fun route(filterText: String): String =
        route.replace("{${Param.FILTER_TEXT.identifier}}", filterText)
}