package com.felipearpa.product.list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.felipearpa.core.formatter.CurrencyFormatter
import com.felipearpa.product.list.application.FindProductsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow

class ProductListViewModel @AssistedInject constructor(
    private val findProductsUseCase: FindProductsUseCase,
    val currencyFormatter: CurrencyFormatter,
    @Assisted val filterText: String
) : ViewModel() {
    val pageSize = 50
    private val prefetchDistance = 5

    private var productPagingSource: ProductPagingSource? = null

    private var _productsFlow = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            prefetchDistance = prefetchDistance,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            ProductPagingSource(
                query = ProductPagingQuery(
                    findProductsUseCase = findProductsUseCase,
                    filterFunc = { filterText }),
                limit = pageSize
            ).also { pagingSource ->
                this.productPagingSource = pagingSource
            }
        }
    ).flow.cachedIn(scope = viewModelScope)
    val productsFlow: Flow<PagingData<ProductModel>>
        get() = _productsFlow
}