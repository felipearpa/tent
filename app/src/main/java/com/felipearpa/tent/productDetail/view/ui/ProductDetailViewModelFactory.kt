package com.felipearpa.tent.productDetail.view.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.AssistedFactory

@AssistedFactory
interface ProductDetailViewModelFactory {

    fun create(productId: String): ProductDetailViewModel

}

fun provideProductDetailViewModelFactory(
    assistedFactory: ProductDetailViewModelFactory,
    productId: String
): ViewModelProvider.Factory =
    object : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return assistedFactory.create(productId = productId) as T
        }

    }