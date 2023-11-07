package com.felipearpa.product.list.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.felipearpa.product.detail.ui.ProductDetailRoute

fun NavGraphBuilder.productListView(navController: NavController) {
    composable(
        route = ProductRoute.route,
        arguments = listOf(
            navArgument(name = ProductRoute.Param.FILTER_TEXT.identifier) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        val filterText =
            navBackStackEntry.arguments!!.getString(ProductRoute.Param.FILTER_TEXT.identifier)
                .orEmpty()
        ProductListView(
            viewModel = productListViewModel(filterText = filterText),
            onDetailRequested = { productId ->
                navController.navigate(route = ProductDetailRoute.route(productId = productId))
            },
            onBack = { navController.navigateUp() }
        )
    }
}
