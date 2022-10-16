package com.felipearpa.ui.routing

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface RouteNavigator {
    val navStateFlow: StateFlow<NavState>
    fun navigate(route: String)
    fun navigateUp()
    fun onNavigated(state: NavState)
}

class DefaultRouteNavigator : RouteNavigator {

    private val _navStateFlow: MutableStateFlow<NavState> =
        MutableStateFlow(NavState.Idle)

    override val navStateFlow: StateFlow<NavState>
        get() = _navStateFlow.asStateFlow()

    override fun navigate(route: String) {
        _navStateFlow.value = NavState.Navigate(route)
    }

    override fun navigateUp() {
        _navStateFlow.value = NavState.NavigateUp()
    }

    override fun onNavigated(state: NavState) {
        _navStateFlow.compareAndSet(state, NavState.Idle)
    }

}