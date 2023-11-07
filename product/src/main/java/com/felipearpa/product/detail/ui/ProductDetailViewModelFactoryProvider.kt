package com.felipearpa.product.detail.ui

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface ProductDetailViewModelFactoryProvider {
    fun productDetailViewModelFactory(): ProductDetailViewModelFactory
}