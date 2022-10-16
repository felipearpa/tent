package com.felipearpa.tent.home.view.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.felipearpa.ui.routing.NavRoute

object HomeRoute : NavRoute<HomeViewModel> {

    override val route: String = "home"

    override val arguments: List<NamedNavArgument> = emptyList()

    @Composable
    override fun Content(viewModel: HomeViewModel) = HomeView(viewModel = viewModel)

    @Composable
    override fun viewModel(navBackStackEntry: NavBackStackEntry): HomeViewModel = hiltViewModel()

}