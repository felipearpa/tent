package com.felipearpa.product.detail.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

fun NavGraphBuilder.productDetailView(navController: NavController) {
    composable(
        route = ProductDetailRoute.route,
        arguments = listOf(
            navArgument(name = ProductDetailRoute.Param.PRODUCT_ID.identifier) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        val productId =
            navBackStackEntry.arguments!!.getString(ProductDetailRoute.Param.PRODUCT_ID.identifier)
                .orEmpty()
        ProductDetailView(
            viewModel = productDetailViewModel(productId = productId),
            onBack = { navController.navigateUp() }
        )
    }
}