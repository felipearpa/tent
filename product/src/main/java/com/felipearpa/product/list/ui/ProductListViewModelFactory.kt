package com.felipearpa.product.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.AssistedFactory

@AssistedFactory
interface ProductListViewModelFactory {
    fun create(filterText: String): ProductListViewModel
}

fun provideProductListViewModelFactory(
    assistedFactory: ProductListViewModelFactory,
    filterText: String
): ViewModelProvider.Factory =
    object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return assistedFactory.create(filterText = filterText) as T
        }
    }