package com.felipearpa.tent.product.view.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.felipearpa.tent.formatter.CurrencyFormatter
import com.felipearpa.tent.product.domain.FindProductsUseCase
import com.felipearpa.tent.product.view.ProductModel
import com.felipearpa.tent.productDetail.view.ui.ProductDetailRoute
import com.felipearpa.ui.routing.RouteNavigator
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow

class ProductViewModel @AssistedInject constructor(
    private val findProductsUseCase: FindProductsUseCase,
    val currencyFormatter: CurrencyFormatter,
    private val routerNavigator: RouteNavigator,
    @Assisted val filterText: String
) : ViewModel(), RouteNavigator by routerNavigator {

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

    fun showProduct(productId: String) {
        navigate(ProductDetailRoute.buildRoute(productId = productId))
    }

    fun goUp() {
        navigateUp()
    }

}