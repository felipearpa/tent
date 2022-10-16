package com.felipearpa.tent.product.view.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.AssistedFactory

@AssistedFactory
interface ProductViewModelFactory {

    fun create(filterText: String): ProductViewModel

}

fun provideProductViewModelFactory(
    assistedFactory: ProductViewModelFactory,
    filterText: String
): ViewModelProvider.Factory =
    object : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return assistedFactory.create(filterText = filterText) as T
        }

    }