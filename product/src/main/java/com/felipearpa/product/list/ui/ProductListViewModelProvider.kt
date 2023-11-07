package com.felipearpa.product.list.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.EntryPointAccessors

@Composable
fun productListViewModel(filterText: String): ProductListViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        ProductListViewModelFactoryProvider::class.java
    ).productListViewModelFactory()
    return viewModel(
        factory = provideProductListViewModelFactory(
            assistedFactory = factory,
            filterText = filterText
        )
    )
}
