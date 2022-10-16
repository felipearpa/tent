package com.felipearpa.ui.routing

import java.util.*

sealed class NavState {

    object Idle : NavState()

    data class Navigate(val route: String, val id: String = UUID.randomUUID().toString()) :
        NavState()

    data class NavigateUp(val id: String = UUID.randomUUID().toString()) : NavState()

}