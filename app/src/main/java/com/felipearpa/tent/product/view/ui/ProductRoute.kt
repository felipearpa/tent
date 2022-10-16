package com.felipearpa.tent.product.view.ui

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

object ProductRoute : NavRoute<ProductViewModel> {

    override val route: String = "products/{filterText}"

    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(name = "filterText") { type = NavType.StringType }
    )

    @Composable
    override fun Content(viewModel: ProductViewModel) = ProductView(viewModel = viewModel)

    @Composable
    override fun viewModel(navBackStackEntry: NavBackStackEntry): ProductViewModel {
        val factory = EntryPointAccessors.fromActivity(
            LocalContext.current as Activity,
            ViewModelFactoryProvider::class.java
        ).productViewModelFactory()
        return androidx.lifecycle.viewmodel.compose.viewModel(
            factory = provideProductViewModelFactory(
                assistedFactory = factory,
                filterText = navBackStackEntry.arguments!!.getString("filterText") ?: emptyString()
            )
        )
    }

    fun buildRoute(filterText: String): String = route.replace("{filterText}", filterText)

}