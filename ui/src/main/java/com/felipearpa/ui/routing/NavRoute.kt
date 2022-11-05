package com.felipearpa.ui.routing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

interface NavRoute<TViewModel : RouteNavigator> {

    val route: String

    val arguments: List<NamedNavArgument>

    @Composable
    fun Content(viewModel: TViewModel)

    @Composable
    fun viewModel(navBackStackEntry: NavBackStackEntry): TViewModel

    fun composable(navGraphBuilder: NavGraphBuilder, navHostController: NavHostController) {
        navGraphBuilder.composable(route, arguments) { navBackStackEntry ->
            val viewModel = viewModel(navBackStackEntry)
            val navigationState by viewModel.navStateFlow.collectAsState()

            LaunchedEffect(navigationState) {
                navigate(navHostController, navigationState, viewModel::onNavigated)
            }

            Content(viewModel)
        }
    }

    private fun navigate(
        navHostController: NavHostController,
        navigationState: NavState,
        onNavigated: (navState: NavState) -> Unit,
    ) {
        when (navigationState) {
            is NavState.Navigate -> {
                navHostController.navigate(navigationState.route)
                onNavigated(navigationState)
            }
            is NavState.NavigateUp -> {
                navHostController.navigateUp()
                onNavigated(navigationState)
            }
            else -> {}
        }
    }
}