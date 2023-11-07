package com.felipearpa.product.list.ui

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface ProductListViewModelFactoryProvider {
    fun productListViewModelFactory(): ProductListViewModelFactory
}