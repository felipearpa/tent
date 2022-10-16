package com.felipearpa.tent

import com.felipearpa.tent.product.view.ui.ProductViewModelFactory
import com.felipearpa.tent.productDetail.view.ui.ProductDetailViewModelFactory
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface ViewModelFactoryProvider {

    fun productViewModelFactory(): ProductViewModelFactory

    fun productDetailViewModelFactory(): ProductDetailViewModelFactory

}