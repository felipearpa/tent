package com.felipearpa.tent.productDetail.view.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipearpa.tent.formatter.CurrencyFormatter
import com.felipearpa.tent.productDetail.domain.FindProductDetailUseCase
import com.felipearpa.tent.productDetail.mapper.ProductDetailMapper
import com.felipearpa.tent.productDetail.view.ProductDetailModel
import com.felipearpa.ui.routing.RouteNavigator
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel @AssistedInject constructor(
    private val findProductDetailUseCase: FindProductDetailUseCase,
    val currencyFormatter: CurrencyFormatter,
    private val routerNavigator: RouteNavigator,
    @Assisted private val productId: String
) : ViewModel(), RouteNavigator by routerNavigator {

    private val _productDetailFlow: MutableStateFlow<ProductDetailModel?> = MutableStateFlow(null)
    val productDetailFlow: Flow<ProductDetailModel?>
        get() = _productDetailFlow.asStateFlow()

    init {
        viewModelScope.launch {
            _productDetailFlow.emit(
                ProductDetailMapper.mapFromDomainToView(
                    findProductDetailUseCase.execute(
                        productId = productId
                    )
                )
            )
        }
    }

    fun goUp() {
        navigateUp()
    }

}