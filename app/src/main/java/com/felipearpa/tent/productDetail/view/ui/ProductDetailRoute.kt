package com.felipearpa.tent.productDetail.view.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.felipearpa.core.emptyString
import com.felipearpa.tent.ViewModelFactoryProvider
import com.felipearpa.ui.routing.NavRoute
import dagger.hilt.android.EntryPointAccessors

object ProductDetailRoute : NavRoute<ProductDetailViewModel> {

    override val route: String = "product/{productId}"

    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(name = "productId") { type = NavType.StringType }
    )

    @Composable
    override fun Content(viewModel: ProductDetailViewModel) =
        ProductDetailView(viewModel = viewModel)

    @Composable
    override fun viewModel(navBackStackEntry: NavBackStackEntry): ProductDetailViewModel {
        val factory = EntryPointAccessors.fromActivity(
            LocalContext.current as Activity,
            ViewModelFactoryProvider::class.java
        ).productDetailViewModelFactory()
        return androidx.lifecycle.viewmodel.compose.viewModel(
            factory = provideProductDetailViewModelFactory(
                assistedFactory = factory,
                productId = navBackStackEntry.arguments!!.getString("productId") ?: emptyString()
            )
        )
    }

    fun buildRoute(productId: String): String = route.replace("{productId}", productId)

}