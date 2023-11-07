package com.felipearpa.tent.home.view.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.felipearpa.product.list.ui.ProductRoute

fun NavGraphBuilder.homeView(navController: NavController) {
    composable(route = HomeRoute.route) {
        HomeView(
            viewModel = homeViewModel(),
            onSearch = { filterText ->
                navController.navigate(route = ProductRoute.route(filterText = filterText))
            }
        )
    }
}