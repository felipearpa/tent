package com.felipearpa.product.detail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipearpa.core.formatter.CurrencyFormatter
import com.felipearpa.product.detail.application.FindProductDetailUseCase
import com.felipearpa.ui.LoadableViewState
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductDetailViewModel @AssistedInject constructor(
    private val findProductDetailUseCase: FindProductDetailUseCase,
    val currencyFormatter: CurrencyFormatter,
    @Assisted private val productId: String
) : ViewModel() {

    private val _state: MutableStateFlow<LoadableViewState<ProductDetailModel>> =
        MutableStateFlow(LoadableViewState.Initial)
    val state: StateFlow<LoadableViewState<ProductDetailModel>>
        get() = _state.asStateFlow()

    fun load() {
        viewModelScope.launch {
            _state.emit(LoadableViewState.Loading)

            val result = findProductDetailUseCase.execute(productId = productId)
            result
                .onSuccess { productDetail ->
                    _state.emit(LoadableViewState.Success(productDetail.toProductDetailModel()))
                }
                .onFailure { exception ->
                    _state.emit(LoadableViewState.Failure(exception))
                }
        }
    }
}