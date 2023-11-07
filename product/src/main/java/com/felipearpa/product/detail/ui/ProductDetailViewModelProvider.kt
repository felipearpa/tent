package com.felipearpa.product.detail.ui

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.EntryPointAccessors

@Composable
fun productDetailViewModel(productId: String): ProductDetailViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        ProductDetailViewModelFactoryProvider::class.java
    ).productDetailViewModelFactory()
    return viewModel(
        factory = provideProductDetailViewModelFactory(
            assistedFactory = factory,
            productId = productId
        )
    )
}