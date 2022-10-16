package com.felipearpa.tent.home.view.ui

import androidx.lifecycle.ViewModel
import com.felipearpa.core.emptyString
import com.felipearpa.tent.product.view.ui.ProductRoute
import com.felipearpa.ui.routing.RouteNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val routerNavigator: RouteNavigator) : ViewModel(),
    RouteNavigator by routerNavigator {

    private val _filterTextFlow = MutableStateFlow(emptyString())
    val filterTextFlow: StateFlow<String>
        get() = _filterTextFlow.asStateFlow()

    fun search(filterText: String) {
        if (filterText.isBlank()) return

        _filterTextFlow.value = filterText.trim()
        navigate(ProductRoute.buildRoute(filterText = _filterTextFlow.value))
    }

}